package com.reiuy.controller;

import java.io.IOException;

/**
 *                      重定向是一种多个Servlet之间互相调用的解决方案
 *
 * 关于运作机制
 *         OneServlet工作完毕后，通过调用响应包中的sendRedirect方法将响应头的location写为two的地址
 *         tomcat会将302的状态码写入状态行，浏览器发现后会根据location地址发起第二次请求
 *         执行two
 *
 *关于定向的内容
 *         其可以写入当前网站的资源文件，也可以写入外部网站的资源文件
 *         例如response.sendRedirect("Https://www.baidu.com");
 *
 *关于请求次数和请求方式
 *         重定向至少发起两次请求，用户发起一次，剩下的由浏览器发起，而请求方式一定是GET
 *         重定向解决方案需要在浏览器和服务器之间进行多次往返，较为消耗时间
 *
 *
 *
 */

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        System.out.println("Oneservlet负责进行第一步");
        response.sendRedirect("/servlet_ReDirect/two");

    }
}
