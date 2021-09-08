package com.reiuy.controller;

import java.io.IOException;

public class ThreeServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String result = "https://www.baidu.com";
        //通过响应对象，将地址赋给响应头中的location属性
        response.sendRedirect(result);
    }

    /*
    *浏览器在收到响应包时如果发现响应头中存在location属性
    * 自动通过地址栏向location指定的地址发送请求
    *
    *
    * sendRedirect方法远程控制浏览器的请求行为【请求地址，请求方式，请求参数】
    * 其中，请求参数用?隔开 例如
    * String result = "http://www.baidu.com?userName=reiuy"
    */
}
