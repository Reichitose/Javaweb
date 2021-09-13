package com.reiuy.controller;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        //1.调用请求对象向Tomcat所要当前用户在服务端中的私人储物柜
        HttpSession session = request.getSession();

        //2.从会话作用域对象得到OneServlet提供的共享数据
        String a = (String)session.getAttribute("key1");

        System.out.println(a);
        System.out.println("TwoServlet负责将存入的session取出");
    }
}
