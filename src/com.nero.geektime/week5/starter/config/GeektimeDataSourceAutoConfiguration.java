package com.nero.geektime.week5;

import com.nero.geektime.week5.starter.src.com.nero.geektime.School;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(com.nero.geektime.week5.Student.class)

public class GeektimeDataSourceAutoConfiguration {

    @Bean
    public School getSchool(com.nero.geektime.week5.Student student) {
        School school = new School();
        school.setStudent(student);
        return school;
    }
}
