package org.itstep.conf;

import org.itstep.data.entity.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    String greetingBean() {
        return "Hello World from SpringBoot Application";
    }

}
