package com.nero.geektime.week3.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Random;

/**
 * 自定义filter类
 */
public class ProxyBizRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        int num = new Random().nextInt();
        fullRequest.setUri(fullRequest.uri()+"?token="+num);
        System.out.println("random is "+num);
    }
}
