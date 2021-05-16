package com.nero.geektime.week1;

public class Hello1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        if (a < b) {
            System.out.println("a less than b");
        } else {
            System.out.println("a more than b");
        }
        System.out.println("a * b ="+(a*b));
        System.out.println("a / b ="+(a/b));
        System.out.println("a + b ="+(a+b));
        System.out.println("b - a ="+(b-a));
        int[] array = new int[]{10,5,20,6,8,2};
        int length = array.length;
        System.out.println("打印数组：");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
