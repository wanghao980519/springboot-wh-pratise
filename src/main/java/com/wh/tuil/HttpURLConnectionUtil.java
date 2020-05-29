package com.wh.tuil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http请求工具类 java原生的使用方式
 * @author WangHao
 * 2020-05-25
 */
public class HttpURLConnectionUtil {

    public static String doGet(String urlStr) {
        // 创建url连接
        HttpURLConnection connection = null;
        // 流
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            // 创建url
            URL url = new URL(urlStr);
            // 打开url
            connection = (HttpURLConnection) url.openConnection();
            // 设置url连接类型
            connection.setRequestMethod("GET");
            // 连接时间和读取时间
            // 连接时间：发送请求端 连接到 url目标地址端的时间
            //          受到距离长短和网络速度的影响
            // 读取时间：指连接成功后 获取数据的时间
            //          受到数据量和服务器处理速度的影响
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            // 设定请求头参数的方式: 如指定接收json数据  服务端的key值为content-type
//            connection.setRequestProperty("Accept", "application/json");
            // 发送请求
            connection.connect();

            if (connection.getResponseCode() != 200) {
                // TODO 此处应添加异常处理
                return "error code";
            }
            // 拿到输入流
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
}
