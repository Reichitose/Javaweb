package com.reiuy.controller;

import java.io.IOException;

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String value = request.getParameter("value");
        System.out.println("接收到了"+value);

        //此处并没有对请求体中的字符集做修改，如果不用filter会乱码
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }
}
