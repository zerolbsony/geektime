package com.nero.geektime.week8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nero.geektime.week8.mapper")
public class SeparateDbTableApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeparateDbTableApplication.class, args);
    }
}
