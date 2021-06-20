package com.nero.geektime.week7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement(order = 10)
@SpringBootApplication
public class ReadWriteSeparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteSeparationApplication.class, args);
    }
}
