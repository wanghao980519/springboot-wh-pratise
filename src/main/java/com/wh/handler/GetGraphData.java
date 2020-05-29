package com.wh.handler;

import com.google.gson.Gson;
import com.wh.tuil.HttpClientUtil;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author WangHao
 * 2020-05-29
 */
public class GetGraphData {

    public static String urlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_other";

    public static void main(String[] args) {
        // 获取实时数据
        String respJson = HttpClientUtil.doGet(urlStr);

        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);
        Map urlMap = gson.fromJson((String) map.get("data"), Map.class);
        ArrayList<Map> list = (ArrayList) urlMap.get("chinaDayList");
        System.out.println(list);
        ArrayList confirmList = new ArrayList();
        ArrayList suspectList = new ArrayList();
        ArrayList deadList = new ArrayList();
        ArrayList healList = new ArrayList();
        ArrayList nowConfirmList = new ArrayList();
        ArrayList nowSevereList = new ArrayList();
        ArrayList importedCaseList = new ArrayList();
        ArrayList deadRateList = new ArrayList();
        ArrayList healRateList = new ArrayList();
        ArrayList dateList = new ArrayList();
        ArrayList noInfectList = new ArrayList();
        // TODO


        for (int i = 0; i < list.size(); i++) {
//            list.get(i).get();
        }
//        {confirm=574.0, suspect=393.0, dead=17.0, heal=25.0, nowConfirm=557.0, nowSevere=0.0, importedCase=0.0, deadRate=3.0, healRate=4.4, date=01.22, noInfect=0.0}

//        confirm -> {Double@3462} 41.0   确诊
//        suspect -> {Double@3464} 0.0    疑似
//        dead -> {Double@3466} 1.0       死亡
//        heal -> {Double@3468} 0.0       治愈
//        nowConfirm -> {Double@3470} 0.0 新增确诊
//        nowSevere -> {Double@3472} 0.0
//        importedCase -> {Double@3474} 0.0   输入






//
//        ArrayList areaTree = (ArrayList) data.get("areaTree");
//        Map areaTreeZero = (Map) areaTree.get(0);
//        ArrayList children = (ArrayList) areaTreeZero.get("children");

//        // 将children中数据提取出来
//        List<DataBean> result = new ArrayList<>();
//        for (int i = 0; i < children.size(); i++) {
//            // 获取省份
//            Map tmp = (Map) children.get(i);
//            // 获取省份下数据
//            Map total = (Map) tmp.get("total");
//            // 省份数据   name
//            String name = (String) tmp.get("name");
//            // 省份下数据 现有确诊
//            double nowConfirm = (Double) total.get("nowConfirm");
//            // 省份下数据 累计确诊
//            double confirm = (Double) total.get("confirm");
//            // 省份下数据 治愈
//            double heal = (Double) total.get("heal");
//            // 省份下数据 死亡
//            double dead = (Double) total.get("dead");
//            result.add(new DataBean(name, (int) nowConfirm, (int) confirm, (int) heal, (int) dead));
//        }
//        return result;
    }

}
