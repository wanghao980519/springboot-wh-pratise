package com.wh.controller;

import com.wh.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("dataList", service.getDate());
        return "list";
    }

}
