package com.nero.geektime.week7.component;

import com.nero.geektime.week7.entity.Order;
import com.nero.geektime.week7.service.impl.OrderServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrderComponent {

    @PostConstruct
    public static void OrderServiceTest() {
        OrderServiceImpl orderService = new OrderServiceImpl();

        //
        Order order = new Order();
        order.setOrderNo(1000002);
        orderService.createOrder(order);

        //
        Order orderDetail = orderService.getOrder(1000001);
        System.out.println("order is " + orderDetail.toString());

        //
        orderDetail.setOrderStatus(1);
        orderDetail.setPayNo("NO001");
        orderDetail.setPayId(1);
        orderService.createOrder(order);

    }
}
