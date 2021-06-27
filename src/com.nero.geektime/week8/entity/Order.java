package com.nero.geektime.week8.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private Integer id;
    private Integer orderNo;
    private Integer orderStatus;
    private Integer userId;
    private String payNo;
    private Integer payId;
    private Integer productAmount;
    private Integer productTotalPrice;
    private Date created;
    private Date updated;
}
