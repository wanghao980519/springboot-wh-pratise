package com.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 如果使用spring-security 需要注释这部分代码
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username,
//                          @RequestParam("password") String password,
//                          Map<String, Object> map , HttpSession session) {
//        if ("admin".equals(username) && "admin".equals(password)) {
//            session.setAttribute("admin",username);
//
//            return "redirect:/";
//        }
//        return "login";
//    }

}
