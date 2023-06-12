package org.itstep.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itstep.data.entity.Question;
import org.itstep.data.entity.Vote;
import org.itstep.data.repository.QuestionRepository;
import org.itstep.data.repository.VoteRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;
//    private final VoteRepository voteRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "question/index";
    }

    @PostMapping
    public String addQuestion( Question question) {
        if (question != null){
            System.out.println("question = " + question);
            Optional<Question> tmp = questionRepository.findByTitle(question.getTitle());
            if (tmp.isEmpty()){
                questionRepository.save(question);
            }
        }
        return "redirect:/question";
    }

    @GetMapping("/eager")
    public String eager(Model model) {
        model.addAttribute("questions", questionRepository.findAllEager());
        return "question/index";
    }

    @GetMapping("/{id}")
    public String showQuery(@PathVariable int id, Model model) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        optionalQuestion.ifPresent(question -> model.addAttribute("question", question));
        return "question/question";
    }

    @PostMapping("/{questionId}")
    public String vote(@PathVariable int questionId, Vote vote) {
        log.info("vote {} for question {}", vote, questionId);
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        optionalQuestion.ifPresent(question -> {
            if (vote != null) {
                //voteRepository.save(vote);
                question.addVote(vote);
                questionRepository.save(question);
            }
        });
        return "redirect:/question";
    }

    @GetMapping("/search")
    public String questionWithTitle(String title, Model model) {
        Optional<Question> foundQuestion = questionRepository.findOne(Example.of(new Question(title)));
        foundQuestion.ifPresent(question -> model.addAttribute("question", question));
        return "question/search";
    }
}
