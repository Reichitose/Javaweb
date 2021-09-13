package com.reiuy.controller;

import java.io.IOException;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
            //1.从同一个请求作用域对象中得到OneServlet中写入的共享数据
            Object value = request.getAttribute("key");
            //2.实际情况中，写入响应体交给浏览器
    }
}
