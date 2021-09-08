package com.reiuy.controller;

import java.io.IOException;
import java.io.PrintWriter;



/**
 *  HttpServletResponse接口
 *
 *  1.来自于servlet规范
 *  2.接口实现类由http服务器提供
 *  3.负责将doGet/doPost方法的执行结果写入到响应体中交给浏览器
 *  4.习惯上将HttpServletResponse接口修饰的对象称为响应对象
 *
 *
 *  功能
 *  1.将执行结果以二进制形式写入响应体
 *  2.设置响应头中[content-type]属性值，控制浏览器用响应的编译器将二进制数据文件编译为
 *  文字图片视频和命令
 */


public class OneServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String result = "Hello World!";  //执行结果 需要被写入响应体

        //-------响应对象将结果写入响应体-------start

            //1.通过响应对象，向tomcat索要输出流
        PrintWriter out = response.getWriter();
            //2.通过输出流，将结果以二进制形式写入响应体
        out.print(result);
        //out.write(result);
        /*
        也同时存在一种写法，即 response.getWriter().print(result)
        而在实际开发时，均使用out.print()方法，原因是write方法会将int自动转换为
        ASCII码进行输入
         */
        //-------响应对象将结果写入响应体-------end
    }
    //doGet执行完毕，tomcat将响应包推送给浏览器
}
