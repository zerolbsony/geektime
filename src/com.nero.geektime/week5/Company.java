package com.nero.geektime.week5;

import com.nero.geektime.week5.aop.ICompany;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class Company implements ICompany {

    // Resource
    @Autowired(required = true) //primary
        Klass class1;

    @Resource(name = "user100")
    User user100;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getUsers().size() + " users and one is " + this.user100);

    }

}