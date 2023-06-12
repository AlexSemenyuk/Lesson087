package org.itstep.init;

import lombok.RequiredArgsConstructor;
import org.itstep.data.entity.Question;
import org.itstep.data.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PopulateQuestions implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        questionRepository.save(new Question("Do you like your work?"));
        questionRepository.save(new Question("Are you going to vocation in Crimea (after liberation) this year?"));
        questionRepository.save(new Question("Do you know Spring Boot?"));
    }
}
