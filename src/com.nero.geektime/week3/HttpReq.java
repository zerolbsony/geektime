package com.nero.geektime.week3;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpReq {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8888/backend");
        HttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = response.getEntity();
            String message = EntityUtils.toString(resEntity, "utf-8");
            System.out.println("响应内容："+message);
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                System.out.println("Key : " + header.getName()
                        + " ,Value : " + header.getValue());
            }
        } else {
            System.out.println("出错了。状态码是："+response.getStatusLine().getStatusCode());
        }
        httpClient.close();
    }
}
