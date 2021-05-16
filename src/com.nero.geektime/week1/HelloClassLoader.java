package com.nero.geektime.week1;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        /*
        Object instance = new HelloClassLoader().findClass("Hello").newInstance();
        Method method = instance.getClass().getMethod("hello");
        System.out.println("执行Hello.xlass文件的hello方法：");
        System.out.println(method.invoke(instance));
        */

        Class clazz = Class.forName(Thread.currentThread().getStackTrace()[1].getClassName());
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
//        for (Method m : clazz.getMethods()) {
//            System.out.println(m.getName());
//        }
        System.out.println("执行Hello.xlass文件的hello方法：");
//        System.out.println(clazz.getMethod("a", String.class).invoke(instance,"Hello"));
        Class newClazz = (Class) clazz.getDeclaredMethod("findClass", String.class).invoke(instance,"Hello");
        Constructor newConstructor = newClazz.getConstructor();
        Object newInstance = newConstructor.newInstance();
        Method method = newClazz.getMethod("hello");
        System.out.println(method.invoke(newInstance));
    }

    public void a(String a) {
        System.out.println(a);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File("/Volumes/storage/workspace/java/geektime/homework/week1/作业相关/Hello/Hello.xlass");
            InputStream fileIn = new FileInputStream(file);
            BufferedInputStream in = new BufferedInputStream(fileIn);
            byte[] bytes = in.readAllBytes();
            int length = bytes.length;
            for (int i = 0; i < length; i++) {
                bytes[i] = (byte) (0xff - bytes[i]);
            }
            return defineClass(name, bytes, 0, length);
        } catch (FileNotFoundException e) {
            return defineClass(name, new byte[]{}, 0, 0);
        } catch (IOException e) {
            return defineClass(name, new byte[]{}, 0, 0);
        }
    }

}
