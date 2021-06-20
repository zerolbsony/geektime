package com.nero.geektime.week7.service.impl;

import com.nero.geektime.week7.entity.Order;
import com.nero.geektime.week7.mapper.OrderMapper;
import com.nero.geektime.week7.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean createOrder(Order order) {
        //        orderMapper.
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        return true;
    }

    @Override
    public Order getOrder(long orderNo) {
        Order order = new Order();
        return order;
    }
}
