package com.wh.controller;

import com.google.gson.Gson;
import com.wh.bean.*;
import com.wh.handler.GetGraphData;
import com.wh.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author WangHao
 * 2020-05-26
 */
@Controller
public class DataController {
    @Autowired
    private DataService service;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("dataList", service.list());
        return "list";
    }

    @GetMapping("/graph")
    public String graph(Model model) {
        ArrayList<GraphBean> list = (ArrayList<GraphBean>) GetGraphData.getDate();
        ArrayList<Integer> nowConfirmList = new ArrayList();
        ArrayList<String> dataList = new ArrayList();
        for (GraphBean graphBean : list) {
            nowConfirmList.add(graphBean.getNowConfirm());
            dataList.add(graphBean.getData());
        }
        model.addAttribute("nowConfirmList", new Gson().toJson(nowConfirmList));
        model.addAttribute("dataList", new Gson().toJson(dataList));
        return "graph";
    }

    @GetMapping("/graphAdd")
    public String graphAdd(Model model) {
        ArrayList<GraphAddBean> list = (ArrayList<GraphAddBean>) GetGraphData.getAddDate();
        ArrayList<String> dataList = new ArrayList();
        ArrayList<Integer> confirmList = new ArrayList();
        ArrayList<Integer> suspectList = new ArrayList();
        for (GraphAddBean graphAddBean : list) {
            dataList.add(graphAddBean.getDate());
            confirmList.add(graphAddBean.getConfirm());
            suspectList.add(graphAddBean.getSuspect());
        }
        model.addAttribute("dataList", new Gson().toJson(dataList));
        model.addAttribute("confirmList", new Gson().toJson(confirmList));
        model.addAttribute("suspectList", new Gson().toJson(suspectList));
        return "graphAdd";
    }

    @GetMapping("/getRate")
    public String getRate(Model model) {
        ArrayList<GraphRate> list = (ArrayList<GraphRate>) GetGraphData.getRate();
        ArrayList<String> dateList = new ArrayList();
        ArrayList<String> healRateList = new ArrayList();
        ArrayList<String> deadRateList = new ArrayList();
        for (GraphRate graphRate : list) {
            dateList.add(graphRate.getDate());
            healRateList.add(graphRate.getHealRate());
            deadRateList.add(graphRate.getDeadRate());
        }
        model.addAttribute("dateList", new Gson().toJson(dateList));
        model.addAttribute("healRateList", new Gson().toJson(healRateList));
        model.addAttribute("deadRateList", new Gson().toJson(deadRateList));
        return "graphRate";
    }

    @GetMapping("/getTotal")
    public String getTotal(Model model) {
        ArrayList<GraphTotal> list = (ArrayList<GraphTotal>) GetGraphData.getTotal();

        ArrayList<String> dateList = new ArrayList();
        ArrayList<Integer> confirmList = new ArrayList();
        ArrayList<Integer> healList = new ArrayList();
        ArrayList<Integer> deadList = new ArrayList();
        for (GraphTotal graphTotal : list) {
            dateList.add(graphTotal.getDate());
            confirmList.add(graphTotal.getConfirm());
            healList.add(graphTotal.getHeal());
            deadList.add(graphTotal.getDead());
        }
        model.addAttribute("dateList", new Gson().toJson(dateList));
        model.addAttribute("confirmList", new Gson().toJson(confirmList));
        model.addAttribute("healList", new Gson().toJson(healList));
        model.addAttribute("deadList", new Gson().toJson(deadList));
        return "getTotal";
    }

    @GetMapping("/GraphColumnar")
    public String GraphColumnar(Model model) {
        ArrayList<GraphColumnarBean> list = (ArrayList<GraphColumnarBean>) GetGraphData.getGraphColumnarData();
        Collections.sort(list);
        ArrayList<String> areaList = new ArrayList();
        ArrayList<Integer> fromAbroadList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            GraphColumnarBean graphColumnarBean = list.get(i);
            areaList.add(graphColumnarBean.getArea());
            fromAbroadList.add(graphColumnarBean.getFromAbroad());

        }
        model.addAttribute("areaList", new Gson().toJson(areaList));
        model.addAttribute("fromAbroadList", new Gson().toJson(fromAbroadList));
        return "GraphColumnar";
    }

    @GetMapping("/GraphPie")
    public String GraphPie(Model model) {
        ArrayList<GraphPie> list = GetGraphData.getGraphPieData();
        model.addAttribute("list", new Gson().toJson(list));
        return "GraphPie";
    }


}
