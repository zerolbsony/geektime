package com.nero.geektime.week5;

import com.nero.geektime.week5.aop.ICompany;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user123 = (User)context.getBean("user123");
        System.out.println(user123.toString());

        user123.print();

        User user100 = (User)context.getBean("user100");
        System.out.println(user100.toString());

        user100.print();

        Klass class1 = context.getBean(Klass.class);
        System.out.println(class1);
        System.out.println("Klass对象AOP代理后的实际类型：" + class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类：" + (class1 instanceof Klass));

        ICompany company = context.getBean(ICompany.class);
        System.out.println(company);
        System.out.println("ICompany接口的对象AOP代理后的实际类型：" + company.getClass());

        ICompany company1 = context.getBean(ICompany.class);
        System.out.println(company1);
        System.out.println("ICompany接口的对象AOP代理后的实际类型：" + company1.getClass());

        company.ding();

        class1.dong();
    }
}
