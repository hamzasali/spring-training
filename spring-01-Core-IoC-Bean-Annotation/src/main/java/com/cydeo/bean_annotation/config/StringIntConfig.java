package com.cydeo.bean_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringIntConfig {

    @Bean
    public String str() {
        return new String();
    }

    @Bean
    public Integer integer() {
        return 0;
    }
}
