package com.nero.geektime.week3.gateway.filter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.FullHttpResponse;


public class ProxyBizResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        String str = "!";
        ByteBuf byteBuf = Unpooled.directBuffer(str.getBytes().length);
        byteBuf.writeBytes(str.getBytes());
        response.content().setBytes(response.content().readableBytes()-1,byteBuf);
    }
}
