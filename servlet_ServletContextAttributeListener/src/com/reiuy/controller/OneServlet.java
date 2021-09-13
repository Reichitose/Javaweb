package com.reiuy.controller;

import jakarta.servlet.ServletContext;

import java.io.IOException;

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        ServletContext application = request.getServletContext();
        application.setAttribute("key","value1");  //创建
        application.setAttribute("key","value2");  //更新
        application.removeAttribute("key");           //销毁
    }
}
