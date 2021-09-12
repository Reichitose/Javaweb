package com.reiuy.controller;

import jakarta.servlet.http.Cookie;

import java.io.IOException;


/**
 * 关于Cookie
 *      1.Cookie来自于Servlet规范中的一个工具类 存在于Tomcat提供的servlet-api中
 *      2.如果两个Servlet来自同一个网站，且为同一个浏览器/用户提供服务
 *   此时可以借助cookie对象进行数据共享
 *      3.Cookie存放当前用户的私人数据，在共享过程中可以提高服务质量
 *      4.在现实生活中，Cookie相当于用户在服务端得到了 【会员卡】
 *
 *
 * 关于Cookie原理
 *
 *      用户通过浏览器第一次向当前网站发起请求申请OneServlet
 *      OneServlet在运行期间创建一个Cookie存储与当前用户相关的数据
 *      OneServlet工作完毕后，将Cookie写入响应头中，并交还给当前的浏览器
 *      浏览器收到响应包后将Cookie存储在浏览器的缓存中
 *                   一段时间之后
 *      当用户通过同一个浏览器向同一个网站发起请求申请TwoServlet时、
 *      浏览器需要无条件的将网站之前推送的Cookie 写入请求头中 发送过去
 *      此时TwoServlet在运行时，就可以通过读取请求头中的cookie中的信息
 *      得到OneServlet提供的共享数据
 *
 *      借此实现Servlet间进行通信
 *
 *
 * 关于Cookie的内容
 *      Cookie相当于一个map
 *      一个Cookie中只能存放一个键值对
 *      这个键值对的key和value只能是String
 *      键值对中的key不能是中文
 *
 *
 * 关于创建Cookie
 *      Cookie card = new Cookie("key","value");
 *      //创建一个Cookie对象，用于保存要共享的数据
 *
 *      response.addCookie(card);
 *      //将Cookie写入到响应头，交给浏览器
 *
 *
 *
 *
 *关于接收Cookie
 *       Cookie cookieArray[] = request.getCookies();
 *      //1.调用请求对象从请求头中得到浏览器返回的Cookie
 *             getCookie方法返回的是一个数组
 *
 *
 *       for(Cookie card:cookieArray){
 *           String key = card.getName();             //读取key
 *           String value = card.getValue();          //读取value
 *
 *                        此处提供服务
 *      }
 *      //2.通过循环遍历这个数组得到每一个Cookie的key，value
 *
 *
 *
 *关于Cookie生命周期
 *      1.在默认情况下，Cookie对象存放在浏览器的缓存中，只要浏览器关闭
 *      Cookie对象就会被销毁掉
 *
 *
 *      2.在手动设置的情况下，可以要求浏览器将接受的Cookie存放在客户端计算机硬盘上
 *      同时需要指定Cookie在硬盘上的存活时间，在存活时间范围内，关闭浏览器，客户端计算机
 *      服务器，都不会导致Cookie被销毁，在存户时间到达时，Cookie自动从硬盘上被删除
 *
 *
 *      定时命令
 *              cookie.setMaxAge(60);   //参数是以秒为单位的，此处是一分钟后销毁
 *
 */

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String userName,money;

        //1.调用请求对象读取请求头中的参数信息
        userName = request.getParameter("userName");
        money = request.getParameter("money");

        //2.开卡
        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("money",money);


        //3.发卡，将cookie写入响应头中
        response.addCookie(card1);
        response.addCookie(card2);


        //4.通知tomcat将点餐页面内容写入响应体
        request.getRequestDispatcher("/index_2.html").forward(request,response);





    }
}
