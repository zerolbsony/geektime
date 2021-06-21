package com.nero.geektime.week7.service.impl;

import com.nero.geektime.week7.entity.Order;
import com.nero.geektime.week7.mapper.OrderMapper;
import com.nero.geektime.week7.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean createOrder(Order order) {
        return orderMapper.insert(order) > 0 ? true : false;
    }

    @Override
    public boolean updateOrder(Order order) {
        try {
            orderMapper.update(order);
        } catch (Exception e) {
            log.error("updateOrder occur exception.", e);
            return false;
        }
        return true;
    }

    @Override
    public Order getOrder(long orderNo) {
        Order order = new Order();
        return order;
    }
}
