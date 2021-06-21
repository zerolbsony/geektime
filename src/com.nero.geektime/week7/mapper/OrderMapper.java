package com.nero.geektime.week7.mapper;

import com.nero.geektime.week7.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    Order getOrder(long orderNo);

    int delete(long orderNo);

    int insert(Order records);

    int update(Order records);

    @Insert("insert into orders(order_no) values(#{orderNo})")
    void addOrder(Order order);

    @Select("select * from laogong where id=#{id}")
    Order queryOrder(int id);
}