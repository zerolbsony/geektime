package com.nero.geektime;

import com.nero.geektime.week8.entity.Order;
import com.nero.geektime.week8.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingSphereTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void createOrder() {
        String str = "a,b,c,,";
        String[] arr = str.split(",");
        System.out.println(arr.length);
        Order order = new Order();
        order.setOrderNo(20001);
        order.setOrderStatus(1);
        order.setUserId(1);
        order.setProductAmount(1);
        order.setProductTotalPrice(10000);
        orderMapper.insert(order);
        Map<String, String> map = new HashMap<>();
//        for (map.entrySet())
        map.values()
            map.entrySet()
    }

    @Test
    public void getOrder() {
        Order order = new Order();
        order.setOrderNo(20001);
        order.setOrderStatus(1);
        order.setUserId(1);
        order.setProductAmount(1);
        order.setProductTotalPrice(10000);
        orderMapper.selectByMap(BeanMap.create(order));
    }

}