package com.reiuy.controller;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 关于HttpSession
 *      1.HttpSession接口来自于Servlet规范下的接口，存放在Tomcat中的servlet-api.jar
 *          其实现类由Http服务器来提供，Tomcat提供实现类存在于servlet-api.jar中
 *      2.如果两个Servlet来自同一个网站，且为同一个浏览器/用户提供服务，则可以
 *           借助于HttpSession对象进行数据共享
 *      3.开发人员习惯于将HttpSession接口修饰的对象称为  会话作用域对象
 *
 *
 * 关于HttpSession和 Cookie的区别
 *      1.储存位置：
 *
 *          一个在天上一个在地下
 *          Cookie存放在客户端计算机（浏览器内存/硬盘）中
 *         HttpSession存放在服务端计算机的内存中
 *
 *      2.数据类型：
 *
 *          Cookie存储的类型只能是String
 *          HttpSession对象可以存储任意类型的共享数据  object
 *
 *
 *      3.数据量
 *
 *          Cookie ：一个Cookie对象只能存储一个共享数据，即一个键值对
 *          HttpSession使用map集合存储，所以可以存任意数量的数据
 *
 *      4.类比
 *
 *          Cookie相当于客户在服务端的一张会员卡
 *          HttpSession相当于客户在服务端的保险柜
 *
 *关于命令
 *
 *
 *        //1.无论是写入共享数据还是取出数据，都需要调用请求对象向Tomcat所要当前用户
 *          在服务端的私人储物柜（HttpSession）
 *
 *         HttpSession session = request.getSession();
 *
 *        //2.将数据添加到私人储物柜中
 *
 *
 *         session.setAttribute("key","需要存放的object");
 *
 *
 *         //3.将数据取出
 *
 *         HttpSession session = request.getSession();
 *         object a = session.getAttribute("key");
 *
 *
 *          在实际情况中，会存在需要取出大量数据的情况，此时
 *          我们利用枚举对象 和循环解决
 *
 *
 *
 *         Enumeration keys = session.getAttributeNames();
 *         //getAttributeNames()会返回一个枚举对象，为所有key的集合，命名keys
 *
 *         while(keys.hasMoreElements()){
 *             String key = (String)keys.nextElement();  //在循环体 中定义局部的key
 *             Object value = session.getAttribute(key)  //通过key取出value，为Object类型（此处善用强转，且该变量绝不为空）
 *         }
 *
 *关于Http服务器如何将用户与HttpSession联系起来
 *      通过Cookie中的Session id之类的字段
 *
 * 关于request.getSession()和request.getSession(false)
 *
 *      1.request.getSession(); 如果当前用户在服务端中已经有了储物柜，则要求tomcat返回这个私人储物柜
 *                              *如果当前用户在服务端中尚未拥有自己的储物柜，则要求tomcat为用户创建一个全新的储物柜
 *      2.request.getSession(false)；
 *                              如果当前用户在服务端中已经有了储物柜，则要求tomcat返回这个私人储物柜
 *                              *如果当前用户在服务端中尚未拥有自己的储物柜，则返回NULL；
 *
 *
 *
 * 关于HttpSession的销毁时机
 *      1.用户与HttpSession所关联时使用的Cookie只能存放在浏览器缓存中
 *
 *      2.浏览器关闭时，意味着用户与他的HttpSession关系被切断
 *
 *      3.由于tomcat无法检测浏览器什么时候关闭，因此在浏览器关闭时
 *        并不会导致tomcat将浏览器关联的HttpSession进行销毁
 *        （类似于手牌丢了，但是柜子里的东西不会丢）
 *
 *
 *      4.为了解决这个问题，tomcat会为每一个HttpSession对象设置空闲时间
 *        这个空闲时间默认为30分钟，如果这个HttpSession对象的空闲时间达到了30分钟
 *        tomcat会认为用户放弃了自己的HttpSession，此时tomcat会销毁掉这个HttpSession
 *
 *
 *
 *
 *
 * 关于HttpSession空闲时间的手动设置
 *     在/web/WEB-INF/web.xml中
 *
 *
 *     <session-config>
 *         <session-timeout>5</session-timeout>  <!--当前网站中每一个session的最大空闲时间为5分钟-->
 *     </session-config>
 *
 *
 */




public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {


        //1.调用请求对象向Tomcat所要当前用户在服务端中的私人储物柜
        HttpSession session = request.getSession();

        //2.将数据以kv的形式添加到私人储物柜
        session.setAttribute("key1","需要存放的object");


        System.out.println("OneServlet负责写入session");




    }
}
