package com.wh.handler;

import com.google.gson.Gson;
import com.wh.bean.DataBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsoupHandler {
    private static String urlStr = "https://ncov.dxy.cn/ncovh5/view/pneumonia";

    public static List<DataBean> getDate() {
        ArrayList<DataBean> result = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(urlStr).get();
            String data = doc.getElementById("getAreaStat").data();
            String subData = data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);
            Gson gson = new Gson();
            ArrayList list = gson.fromJson(subData, ArrayList.class);
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String provinceName = (String) map.get("provinceName");// 地区
                double currentConfirmedCount = (double) map.get("currentConfirmedCount");// 现有确诊
                double confirmedCount = (double) map.get("confirmedCount");// 累计确诊
                double curedCount = (double) map.get("curedCount");// 治愈
                double deadCount = (double) map.get("deadCount");// 死亡
                result.add(new DataBean(provinceName, (int) currentConfirmedCount, (int) confirmedCount, (int) curedCount, (int) deadCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
