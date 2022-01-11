package com.project.userdevices.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public CascadingMongoEventListener userCascadingMongoEventListener() {
        return new CascadingMongoEventListener();
    }
}
