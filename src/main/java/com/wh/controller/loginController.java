package com.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Map<String, Object> map , HttpSession session) {
        if ("admin".equals(username) && "admin".equals(password)) {
            session.setAttribute("admin",username);

            return "redirect:/";
        }
        return "login";
    }

}
