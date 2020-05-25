package com.wh.handler;

import com.google.gson.Gson;
import com.wh.bean.DataBean;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataHandler {
    public static List<DataBean> getDate() throws Exception {
        // 将data.txt 内容读取到builder
        StringBuilder builder = new StringBuilder();
        FileReader fr = new FileReader("data.txt");
        char[] cBuf = new char[1024];
        int cRead = 0;
        while ((cRead = fr.read(cBuf)) > 0) {
            builder.append(new String(cBuf, 0, cRead));
        }
        fr.close();

        // 找到装有各省数据的位置children
        Gson gson = new Gson();
        Map map = gson.fromJson(builder.toString(), Map.class);
        Map data = gson.fromJson((String) map.get("data"), Map.class);
        ArrayList areaTree = (ArrayList) data.get("areaTree");
        Map areaTreeZero = (Map) areaTree.get(0);
        ArrayList children = (ArrayList) areaTreeZero.get("children");

        // 将children中数据提取出来
        List<DataBean> result = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            Map tmp = (Map) children.get(i);    // 获取省份
            Map total = (Map) tmp.get("total"); // 获取省份下数据
            String name = (String) tmp.get("name");                 // 省份数据   name
            double nowConfirm = (Double) total.get("nowConfirm");   // 省份下数据 现有确诊
            double confirm = (Double) total.get("confirm");         // 省份下数据 累计确诊
            double heal = (Double) total.get("heal");               // 省份下数据 治愈
            double dead = (Double) total.get("dead");               // 省份下数据 死亡
            result.add(new DataBean(name, (int) nowConfirm, (int) confirm, (int) heal, (int) dead));
        }
        return result;
    }


}
