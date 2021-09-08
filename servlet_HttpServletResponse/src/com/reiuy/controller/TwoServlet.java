package com.reiuy.controller;

import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String result = "Java<br/>Golang<br/>Blockchain<br/>"; //文字和标签命令
        String result_CN= "牛犇<br/>马哲<br/>石子怡";
        response.setContentType("text/html;charset=utf-8");
        //索要输出流之前设置响应头中的contentType值


        PrintWriter out = response.getWriter();

        out.print(result);
        out.print(result_CN);
    }
}
