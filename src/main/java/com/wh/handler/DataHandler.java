package com.wh.handler;

import com.google.gson.Gson;
import com.wh.bean.DataBean;
import com.wh.service.DataService;
import com.wh.tuil.HttpURLConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WangHao
 * 2020-05-25
 */
@Component
public class DataHandler {

    @Autowired
    DataService service;

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

    /**
     * 初始化更新数据
     * @PostConstruct 用该注释修饰对方法会在类加载时执行一次，只执行一次。
     */
    @PostConstruct
    public void saveData() {
        List<DataBean> dataBean = getDate();
        // 先将数据清空 然后存储数据
        service.remove(null);
        service.saveBatch(dataBean);
    }

    /**
     * @Scheduled()
     * 配置定时执行的注解,支持cron表达式
     */
    @Scheduled(cron = "0/5 0/10 * * * ? *")
    public void upDateData() {
        System.out.println("更新数据");
        saveData();
    }

}
