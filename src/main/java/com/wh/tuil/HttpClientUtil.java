package com.wh.tuil;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * http请求工具类 HttpClientUtil方式,比原生的牛逼
 *
 * @author WangHao
 * 2020-05-29
 */
public class HttpClientUtil {
    public static String doGet(String urlStr) {
        // 提供了 闭合的Httpclient对象
        CloseableHttpClient httpClient = null;
        // 提供了 闭合Httpclient响应对象
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try {
            // 使用默认创建方式
            httpClient = HttpClients.createDefault();
            // 创建一个get请求，传入url
            HttpGet httpGet = new HttpGet(urlStr);
            // 设置请求头的方式
            httpGet.addHeader("Accept", "application/json");
            // 设置请求参数  连接时间 读取时间 等
            // setConnectionRequestTimeout 从共享连接池拿到连接的时间的超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(35000)
                    .setConnectionRequestTimeout(35000)
                    .setSocketTimeout(60000).build();
            // 设置配置
            httpGet.setConfig(requestConfig);
            // 执行请求
            httpResponse = httpClient.execute(httpGet);
            // 从返回对象中获取返回数据
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

}
