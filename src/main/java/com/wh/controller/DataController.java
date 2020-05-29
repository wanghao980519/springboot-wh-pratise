package com.wh.controller;

import com.google.gson.Gson;
import com.wh.bean.GraphBean;
import com.wh.handler.GetGraphData;
import com.wh.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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

}
