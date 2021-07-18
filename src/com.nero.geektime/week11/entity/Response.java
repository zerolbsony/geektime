package com.nero.geektime.week11.entity;

import lombok.Data;

@Data
public class Response {

	public int errorCode;

	public String errorMsg;

	public Map<String, Object> data;
}
