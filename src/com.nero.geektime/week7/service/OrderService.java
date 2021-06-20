package com.nero.geektime.week7.service;

import com.nero.geektime.week7.annotate.ReadOnly;
import com.nero.geektime.week7.entity.Order;

public interface OrderService {

    public boolean createOrder(Order order);

    public boolean updateOrder(Order order);

    @ReadOnly
    public Order getOrder(long orderNo);
}
