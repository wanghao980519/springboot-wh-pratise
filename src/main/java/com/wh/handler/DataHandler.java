package com.wh.handler;

import com.google.gson.Gson;
import com.wh.bean.DataBean;
import com.wh.tuil.HttpURLConnectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WangHao
 * 2020-05-25
 */
public class DataHandler {

    public static String urlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";

    public static List<DataBean> getDate() {
        // 获取实时数据
        String respJson = HttpURLConnectionUtil.doGet(urlStr);

        // 找到装有各省数据的位置children
        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);
        Map data = gson.fromJson((String) map.get("data"), Map.class);
        ArrayList areaTree = (ArrayList) data.get("areaTree");
        Map areaTreeZero = (Map) areaTree.get(0);
        ArrayList children = (ArrayList) areaTreeZero.get("children");

        // 将children中数据提取出来
        List<DataBean> result = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            // 获取省份
            Map tmp = (Map) children.get(i);
            // 获取省份下数据
            Map total = (Map) tmp.get("total");
            // 省份数据   name
            String name = (String) tmp.get("name");
            // 省份下数据 现有确诊
            double nowConfirm = (Double) total.get("nowConfirm");
            // 省份下数据 累计确诊
            double confirm = (Double) total.get("confirm");
            // 省份下数据 治愈
            double heal = (Double) total.get("heal");
            // 省份下数据 死亡
            double dead = (Double) total.get("dead");
            result.add(new DataBean(name, (int) nowConfirm, (int) confirm, (int) heal, (int) dead));
        }
        return result;
    }

}
