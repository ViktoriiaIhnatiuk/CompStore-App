package com.example.compstore.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.example.compstore")
public class AppConfig {
    private final Environment environment;
    private final ObjectMapper objectMapper;

    public AppConfig(Environment environment, ObjectMapper objectMapper) {
        this.environment = environment;
        this.objectMapper = objectMapper;
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }


    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
