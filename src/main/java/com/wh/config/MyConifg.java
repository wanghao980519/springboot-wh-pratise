package com.wh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 国际化
 */
@Configuration
public class MyConifg {
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();

    }
}
