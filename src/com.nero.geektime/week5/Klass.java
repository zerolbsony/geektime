package com.nero.geektime.week5;

import lombok.Data;

import java.util.List;

@Data
public class Klass {

    List<User> users;

    public void dong() {
        System.out.println(this.getUsers());
    }
}
