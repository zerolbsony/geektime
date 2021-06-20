package com.nero.geektime.week5;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("geektime.student")
public class Student {

    private int id;

    private String name;
}