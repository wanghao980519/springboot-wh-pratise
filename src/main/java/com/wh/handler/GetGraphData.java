package com.wh.handler;

import com.google.gson.Gson;
import com.wh.bean.DataBean;
import com.wh.bean.GraphBean;
import com.wh.tuil.HttpClientUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WangHao
 * 2020-05-29
 */
public class GetGraphData {

    public static String urlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_other";

    public static List<GraphBean> getDate() {
        // 获取实时数据
        String respJson = HttpClientUtil.doGet(urlStr);
        ArrayList<GraphBean> result = new ArrayList<>();
        // 将获取的数据转换成对象挑选出有用的
        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);
        Map urlMap = gson.fromJson((String) map.get("data"), Map.class);
        ArrayList<Map> list = (ArrayList) urlMap.get("chinaDayList");
        // 将数据添加道数组
        for (int i = 0; i < list.size(); i++) {
            Map tmp = list.get(i);
            String data = (String) tmp.get("date");
            double nowConfirm = (double) tmp.get("nowConfirm");
            result.add(new GraphBean(data, (int) nowConfirm));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getDate());
    }

}
