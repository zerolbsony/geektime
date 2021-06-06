package com.nero.geektime;

import com.nero.geektime.week5.starter.src.com.nero.geektime.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(com.nero.geektime.Student.class)

public class GeektimeDataSourceAutoConfiguration {

    @Bean
    public School getSchool(com.nero.geektime.Student student) {
        School school = new School();
        school.student = student;
        return school;
    }
}
