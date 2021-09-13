package com.reiuy.controller;

import java.io.IOException;

/**
 * 关于请求作用域HttpServletRequest接口
 *      1.在同一个网站中，如果两个Servlet之间通过请求转发方式进行调用，彼此之间会共享一个请求协议包
 *          而一个请求协议班只能对应一个请求对象，因此Servlet之间会共享一个请求对象，此时可以通过这个
 *          请求对象在两个Servlet之间实现数据共享
 *
 *      2.在请求对象实现Servlet之间数据共享功能时，开发人员将请求对象称为请求作用域对象
 *
 *
 *关于命令实现
 *        //1.将数据添加到请求作用域对象中的Attribute属性
 *        request.setAttribute("key","需要传递的数据object");
 *        //同样的，该数据以map的形式存在于作用域对象中，需要kv
 *
 *        //2.向tomcat申请调用TwoServlet
 *        request.getRequestDispatcher("/two").forward(request,response);
 *        //此处和请求转发一致
 *
 *
 *        //3.从当前请求对象得到前一个servlet写入的共享数据
 *
 *        Object value = request.getAttribute("key");
 *
 *
 *                   ******注意********
 *
 *          在正常的需要多个servlet完成的任务时，无论是请求转发还是重定向，
 *          一般都由最后一个servlet负责吧最终结果写入响应体，
 *          之前的servlet所产生的数据都是通过这种方式逐级传递信息
 *
 *
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
        //1.将数据添加到请求作用域对象，作为共享数据
        request.setAttribute("key","需要传递的数据object");

        //2.代替浏览器，向tomcat所要TwoServlet来完成剩余任务
        request.getRequestDispatcher("/two").forward(request,response);

    }
}
