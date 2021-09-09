package com.reiuy.controller;

import java.io.IOException;

public class OneServlet extends jakarta.servlet.http.HttpServlet {
  
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        //1.通过当前的请求对象，读取请求行中的url
        String url = request.getRequestURL().toString();

        
        //2.通过请求对象，读取请求行中的method信息
        String method = request.getMethod();


        //3.通过请求对象，读取uri信息
        /*
        * URI 资源文件精准定位地址，在请求行中没有这个属性
        * 实际上是从url中截取的一个字符串，其格式为“/网站名/资源文件名”
        * URI用于让http服务器对被访问的资源文件进行定位
        *
        */
        String uri = request.getRequestURI();



        System.out.println("url:"+url);
        System.out.println("method:"+method);
        System.out.println("uri:"+uri);
    }
}
