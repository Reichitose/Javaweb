package com.reiuy.controller;

import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {
    
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        //1.通过请求对象获得当前请求行中所有请求参数的名称
        Enumeration paramNames = request.getParameterNames();
        //getParameterNames将所有请求参数名称保存到一个枚举对象中进行返回
        while(paramNames.hasMoreElements()){
            String paraName = (String)paramNames.nextElement();
            //利用while循环遍历参数名

            String value = request.getParameter(paraName);
            //遍历请求参数值

            System.out.println("请求参数名"+paraName+"请求参数值"+value);
        }
    }
}
