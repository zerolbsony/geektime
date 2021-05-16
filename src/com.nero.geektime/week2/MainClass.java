package com.nero.geektime.week2;

import com.nero.geektime.week2.netty.NettyHttpServer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) throws Exception {
        Map<String, Class> map = new HashMap<>();
        map.put("1", HttpServer01.class);
        map.put("2", HttpServer02.class);
        map.put("3", HttpServer03.class);
        map.put("8", NettyHttpServer.class);

        String id = (null == args || args.length == 0) ? "1" : args[0];
        Class clazz = map.get(id);
        if( null == clazz ) {
            System.out.println("No class for id: " + id);
        }

        try {
            Method method = clazz.getDeclaredMethod("main", new Class[]{String[].class});
            method.invoke(null, new Object[]{new String[]{}});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}