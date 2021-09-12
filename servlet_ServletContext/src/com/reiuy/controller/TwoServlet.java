package com.reiuy.controller;

import jakarta.servlet.ServletContext;

import java.io.IOException;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        //1.通过请求对象向tomcat所要当前网站的全局作用域对象
        ServletContext application = request.getServletContext();
        //2.从全局作用域对象中得到指定key对应的值
        String a = (String) application.getAttribute("key1");
        //此处取出的是一个obj类型的，可能需要强转，例如数字最好使用Integer进行转换避免空值报错
    }
}
