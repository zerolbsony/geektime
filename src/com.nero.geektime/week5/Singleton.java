package com.nero.geektime.week5;

/**
 * 饿汉式
 * 注意：instance作为类变量在类初始化的过程中会被收集进<clinit>()方法中，该方法能百分百保证同步，instance在多线程下不可能被实例化两次。
 * 问题：但instance被ClassLoader加载后可能很长一段时间才被使用，instance实例占用的堆内存会驻留更久的时间，无法懒加载。适合类成员属性少的且占用内存资源少的情况。
 */
public final class Singleton {
    private byte[] data = new byte[1024];

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 懒汉式
 * 问题：多个线程同时看到instance == null，instance无法保证单例唯一性
 */
final class Singleton1 {
    private byte[] data = new byte[1024];

    private static Singleton1 instance = null;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return instance;
    }
}

/**
 * 懒汉式 + 同步方法
 * 问题：懒加载且线程安全，synchronized导致getInstance方法只能在同一时刻被一个线程访问，性能低下。
 */
final class Singleton2 {
    private byte[] data = new byte[1024];

    private static Singleton2 instance = null;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * Double check
 * 好处：允许多个线程同时对getInstance方法进行访问。
 * 问题：多线程下有可能会引起空指针异常（当成员变量有很多是资源类的对象如conn和socket，实例化是无序的，可能先有了instance实例化，在conn未实例化之前调用了conn.query()报空指针了。
 */
final class Singleton3 {
    private byte[] data = new byte[1024];

    private static Singleton3 instance = null;

    private Singleton3() {

    }

    public static synchronized Singleton3 getInstance() {
        if (null == instance) {
            synchronized (Singleton3.class) {
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * Volatile + Double check
 *
 */
final class Singleton4 {
    private byte[] data = new byte[1024];

    private volatile static Singleton4 instance = null;

    private Singleton4() {

    }

    public static synchronized Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * Holder方式
 *
 */
final class Singleton5 {
    private byte[] data = new byte[1024];

    private Singleton5() {

    }

    private static class Holder {
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Holder.instance;
    }
}

/**
 * 枚举方式
 */
enum  Singleton6 {

    INSTANCE;

    private byte[] data = new byte[1024];

    Singleton6() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    private static void method() {
        //调用该方法则会主动使用Singleton6，INSTANCE将会被实例化
    }

    public static Singleton6 getInstance() {
        return INSTANCE;
    }
}

/**
 * 枚举增加懒加载特性，类似Holder方式
 */
class Singleton7 {
    private byte[] data = new byte[1024];

    private Singleton7() {

    }

    private enum EnumHolder {
        INSTANCE;
        private Singleton7 instance;

        EnumHolder() {
            this.instance = new Singleton7();
        }

        private Singleton7 getSingleton() {
            return instance;
        }
    }

    public static Singleton7 getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }
}

