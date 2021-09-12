package com.reiuy.controller;

import jakarta.servlet.ServletContext;

import java.io.IOException;


/**
 *
 *  如果两个servlet 来自于同一个网站，彼此之间可以通过ServletContext实例对象实现数据共享
 *  ServletContext对象一般被称为全局作用域对象
 *
 *     无论是将数据存入全局作用对象还是需要使用，都需要先通过getServletContext请求当前网站的全局作用域对象
 *
 *     全局作用域对象是一个类似于map的kv数据结构
 *
 *     存入和使用方法分别为setAttribute和getAttribute
 *
 *
 *
 *
 *
 */

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        //1.通过请求对象向tomcat所要当前网站的全局作用域对象
        ServletContext application = request.getServletContext();
        //2.将数据添加到全局作用域对象中，作为共享数据，结构为类似于map的key value
        application.setAttribute("key1","此处为需要存放的数据，类型为obj");
    }


}
