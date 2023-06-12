package org.itstep.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@ConditionalOnClass(name = "org.itstep.dependency.RequiredClass")
public class AutoConfiguration {
    @Bean
    public LocalDateTime currentTime() {
        log.info("Required bean present in classpath");
        return LocalDateTime.now();
    }
}
