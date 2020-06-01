package com.wh.handler;

import com.google.gson.Gson;
import com.wh.bean.*;
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
    public static Map urlMap = null;

    static {
        // 获取实时数据
        String respJson = HttpClientUtil.doGet(urlStr);
        // 将获取的数据转换成对象挑选出有用的
        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);
        urlMap = gson.fromJson((String) map.get("data"), Map.class);
    }

    public static List<GraphBean> getDate() {
        ArrayList<Map> list = (ArrayList) urlMap.get("chinaDayList");
        ArrayList<GraphBean> result = new ArrayList<>();
        // 将数据添加道数组
        for (int i = 0; i < list.size(); i++) {
            Map tmp = list.get(i);
            String data = (String) tmp.get("date");
            double nowConfirm = (double) tmp.get("nowConfirm");
            result.add(new GraphBean(data, (int) nowConfirm));
        }
        return result;
    }

    public static List<GraphAddBean> getAddDate() {
        ArrayList<Map> list = (ArrayList) urlMap.get("chinaDayAddList");
        ArrayList<GraphAddBean> result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map tmp = list.get(i);
            String data = (String) tmp.get("date");
            double confirm = (double) tmp.get("confirm");
            double suspect = (double) tmp.get("suspect");
            result.add(new GraphAddBean(data, (int) confirm, (int) suspect));
        }
        return result;
    }

    public static List<GraphRate> getRate() {
        ArrayList<Map> list = (ArrayList) urlMap.get("chinaDayList");
        ArrayList<GraphRate> result = new ArrayList<>();
        // 将数据添加道数组
        for (int i = 0; i < list.size(); i++) {
            Map tmp = list.get(i);
            String date = (String) tmp.get("date");
            String healRate = (String) tmp.get("healRate");
            String deadRate = (String) tmp.get("deadRate");
            result.add(new GraphRate(date, healRate, deadRate));
        }
        return result;
    }

    public static List<GraphTotal> getTotal() {
        ArrayList<Map> list = (ArrayList) urlMap.get("chinaDayList");
        ArrayList<GraphTotal> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map tmp = list.get(i);
            String date = (String) tmp.get("date");
            double confirm = (double) tmp.get("confirm");
            double heal = (double) tmp.get("heal");
            double dead = (double) tmp.get("dead");
            result.add(new GraphTotal(date, (int) confirm, (int) heal, (int) dead));
        }
        return result;
    }

    public static List<GraphColumnarBean> getGraphColumnarData() {

        String urlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
        List<GraphColumnarBean> result = new ArrayList<>();

        String respJson = HttpClientUtil.doGet(urlStr);
        // 找到装有各省数据的位置children
        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);
        Map subMap = gson.fromJson((String) map.get("data"), Map.class);
        ArrayList areaTree = (ArrayList) subMap.get("areaTree");
        Map areaTreeZero = (Map) areaTree.get(0);
        ArrayList<Map> children = (ArrayList) areaTreeZero.get("children");
        for (int i = 0; i < children.size(); i++) {
            Map tmp = children.get(i);
            String area = (String) tmp.get("name");
            ArrayList childern = (ArrayList) tmp.get("children");
            for (int y = 0; y < childern.size(); y++) {
                Map subTmp = (Map) childern.get(y);
                if ("境外输入".equals(subTmp.get("name"))) {
                    Map total = (Map) subTmp.get("total");
                    double confirm = (double) total.get("confirm");
                    GraphColumnarBean graphColumnarBean = new GraphColumnarBean(area, (int) confirm);
                    result.add(graphColumnarBean);
                    break;
                }
            }

        }
        return result;
    }

    public static ArrayList<GraphPie> getGraphPieData() {
        Map nowConfirmStatis = (Map) urlMap.get("nowConfirmStatis");
        ArrayList<GraphPie> result = new ArrayList<>();
        for (Object o : nowConfirmStatis.keySet()) {
            String name = (String) o;
            switch (name) {
                case "gat":
                    name = "港澳台病例";
                    break;
                case "import":
                    name = "境外输入病例";
                    break;
                case "province":
                    name = "31省本土病例";
                    break;
            }
            double value = (double) nowConfirmStatis.get(o);
            name += ":" + (int) value + "例";
            result.add(new GraphPie(name, ((int) value)));

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getGraphPieData());
    }

}
