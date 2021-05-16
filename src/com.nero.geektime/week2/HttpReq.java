package com.nero.geektime.week2;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpReq {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8801");
        HttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = response.getEntity();
            String message = EntityUtils.toString(resEntity, "utf-8");
            System.out.println("状态码："+response.getStatusLine().getStatusCode());
            System.out.println("响应状态："+response.getStatusLine());
            System.out.println("地区："+response.getLocale());
            System.out.println("返回数据类型："+resEntity.getContentType());
            System.out.println("响应内容："+message);
        } else {
            System.out.println("出错了。状态码是："+response.getStatusLine().getStatusCode());
        }
    }
}
