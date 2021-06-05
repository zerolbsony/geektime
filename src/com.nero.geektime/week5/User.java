package com.nero.geektime.week5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable, BeanNameAware, ApplicationContextAware {

    public int id;

    public String name;

    private String beanName;
    private ApplicationContext applicationContext;

    public void init() {
        System.out.println("hello...........");
    }

    public void print() {
        System.out.println(this.beanName);
        System.out.println("   context.getBeanDefinitionNames() ===>> " + String
            .join(",", applicationContext.getBeanDefinitionNames()));

    }
}
