package com.nero.geektime.week7.entity;

import lombok.Data;

@Data
public class Order {
    public int id;

    public long orderNo;

    public int orderStatus;

    public int userId;

    public String payNo;

    public int payId;

    public int productAmount;

    public int productTotalPrice;

    public String created;

    public String updated;
}
