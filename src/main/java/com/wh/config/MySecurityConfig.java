package com.wh.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设定角色的权限 (角色和资源的对应关系)
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/*").hasRole("VIP1")
                .antMatchers("/level2/*").hasRole("VIP2")
                .antMatchers("/level3/*").hasRole("VIP3");
        // 开启自动配置的登陆功能
        http.formLogin().usernameParameter("username").usernameParameter("password")
                .loginPage("/login");

//        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 密码需要加密处理才行

        String root = new BCryptPasswordEncoder().encode("root");
        String student = new BCryptPasswordEncoder().encode("student");
        String guest = new BCryptPasswordEncoder().encode("guest");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())

                .withUser("root")
                .password(root).roles("VIP1", "VIP2","VIP3")
                .and()
                .withUser("student")
                .password(student).roles("VIP1", "VIP2")
                .and()
                .withUser("guest")
                .password(guest).roles("VIP1");


    }
}
