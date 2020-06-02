package com.wh;

import com.wh.handler.MailHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class SpringbootWhPractiseApplicationTests {

    @Autowired
    private MailHandler mailHandler;


    @Test

    void contextLoads() throws MessagingException {
        mailHandler.sendByTemplate();

    }

}
