package org.itstep.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final String greetingBean;
    private final LocalDateTime currentTime;

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("title", greetingBean);
        model.addAttribute("title", currentTime);
        return "index";
    }
}
