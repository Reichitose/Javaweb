package com.reiuy.controller;

import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

/**
 *          请求转发是一种多个Servlet之间调用的实现方法
 *
 *
 *关于请求转发
 *         无论本次请求涉及到多少个Servlet，用户只需要通过浏览器发送一次请求
 *         servlet之间的调用发生在服务端计算机上，能节省服务端与浏览器之间的往返次数
 *关于请求次数
 *         在请求转发中，浏览器只发起一次请求
 *         只能向tomcat服务器申请调用当前网站下的资源文件地址，格式为/+资源文件名，不能是外部网站
 *
 *
 * 关于请求方式
 *         由于本次请求转发过程中，浏览器只发送了一个Http请求响应包，参与本次请求的所有servlet共享同一个请求协议包
 *         因此这些servlet接收的请求方式与浏览器的发送方式保持一致
 *
 *
 */

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        System.out.println("OneServlet负责完成第一步");


        //首先通过getRequestDispatcher获得资源文件申请报告对象
        RequestDispatcher report = request.getRequestDispatcher("/two");

        //将报告对象通过forward方法发送给tomcat，参数为该doGet方法的请求对象和响应对象
        report.forward(request,response);

    }
}
