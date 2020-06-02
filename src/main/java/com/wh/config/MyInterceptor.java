package com.wh.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----MyInterceptor----preHandle----");

        HttpSession session = request.getSession();
        Object user = session.getAttribute("admin");

        if (user != null) {
            return true;
        }
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----MyInterceptor----afterCompletion----");
    }
}
