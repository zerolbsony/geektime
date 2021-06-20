package com.nero.geektime.week7.mapper;

import com.nero.geektime.week7.entity.Order;

public interface OrderMapper {

    Order getOrder(long orderNo);

    int delete(long orderNo);

    int insert(Order records);

    int update(Order records);
}