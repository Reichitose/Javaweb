package com.reiuy.controller;

import java.io.IOException;

public class ThreeServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //此处可以规定用utf8字符集对二进制内容进行解码防止乱码，注意要在请求体之前
        String value2 = request.getParameter("userName");
        System.out.println("从请求行中得到参数值"+value2);
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        //通过请求对象读取请求行中的参数信息
        String value1 = request.getParameter("userName");
        System.out.println("从请求行中得到参数值"+value1);
    }
}
