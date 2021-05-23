package com.nero.geektime.week3.gateway.inbound;

import com.nero.geektime.week3.gateway.filter.HeaderHttpRequestFilter;
import com.nero.geektime.week3.gateway.filter.HttpRequestFilter;
import com.nero.geektime.week3.gateway.filter.ProxyBizRequestFilter;
import com.nero.geektime.week3.gateway.filter.ProxyBizResponseFilter;
import com.nero.geektime.week3.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.ReferenceCountUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static io.netty.handler.codec.rtsp.RtspHeaderNames.CONNECTION;
import static io.netty.handler.codec.rtsp.RtspHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.rtsp.RtspResponseStatuses.OK;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            //logger.info("channelRead流量接口请求开始，时间为{}", startTime);
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            String uri = fullRequest.uri();
//            //logger.info("接收到的请求url为{}", uri);
//            if (uri.contains("/test")) {
//                handlerTest(fullRequest, ctx);
//            }
            //
            if (uri.contains("/backend")) {
                handlerBackend(fullRequest, ctx);
                return;
            }

            handler.handle(fullRequest, ctx, filter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

//    private void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
//        FullHttpResponse response = null;
//        try {
//            String value = "hello,kimmking";
//            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
//            response.headers().set("Content-Type", "application/json");
//            response.headers().setInt("Content-Length", response.content().readableBytes());
//
//        } catch (Exception e) {
//            logger.error("处理测试接口出错", e);
//            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
//        } finally {
//            if (fullRequest != null) {
//                if (!HttpUtil.isKeepAlive(fullRequest)) {
//                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
//                } else {
//                    response.headers().set(CONNECTION, KEEP_ALIVE);
//                    ctx.write(response);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();
//    }

    /**
     * 采用httpclient封装调用下游的逻辑
     *
     * @param fullRequest
     * @param ctx
     */
    public void handlerBackend(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        FullHttpResponse res = null;
        String message = null;
        new ProxyBizRequestFilter().filter(fullRequest, ctx);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(this.proxyServer.get(0));
            System.out.println("new uri is " + httpGet.getURI() + fullRequest.uri());
            URI uri = new URI(httpGet.getURI() + fullRequest.uri());
            httpGet.setURI(uri);

            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity resEntity = response.getEntity();
                message = EntityUtils.toString(resEntity, "utf-8");
                System.out.println("响应内容：" + message);
            } else {
                HttpEntity resEntity = response.getEntity();
                message = EntityUtils.toString(resEntity, "utf-8");
                System.out.println("出错了。状态码是：" + response.getStatusLine().getStatusCode());
            }
            httpClient.close();

            res = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(message.getBytes("UTF-8")));
            res.headers().set("Content-Type", "application/json");
            res.headers().setInt("Content-Length", res.content().readableBytes());

            new ProxyBizResponseFilter().filter(res);
        } catch (Exception e) {
            System.out.println("调用下游服务失败。异常：" + e.getMessage());
            res = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(res).addListener(ChannelFutureListener.CLOSE);
                } else {
                    res.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(res);
                }
            }
        }
    }
}
