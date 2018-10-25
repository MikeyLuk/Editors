package com.andymitchell.divedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;

@SpringBootApplication
public class DiveDbApplication {

    public static void main(String[] args) {

        SpringApplication.run(DiveDbApplication.class, args);
    }
}
