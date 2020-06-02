package com.wh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author WangHao
 * 2020-05-25
 * @EnableScheduling 该注解表示打开定时更新的使用
 */
@SpringBootApplication
@MapperScan("com.wh.mapper")
@EnableScheduling
public class SpringbootWhPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWhPractiseApplication.class, args);
    }

}

