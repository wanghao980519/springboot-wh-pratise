package com.wh.controller;

import com.wh.handler.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * 异步处理
 */
@RestController
public class MailContorller {

    @Autowired
    private MailHandler mailHandler;


    @GetMapping("/async")
    public String async() throws MessagingException {

        mailHandler.sendByTemplate();
        System.out.println("执行完了");
        return "success";
    }
}
