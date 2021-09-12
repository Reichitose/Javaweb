package com.reiuy.controller;

import com.reiuy.dao.UserDao;
import com.reiuy.entity.Users;

import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        //定义需要的注册信息并定义Dao对象,声明user对象用于发送,并定义结果result和用于写入响应包的printwriter
        String userName,password,sex,email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;

        //1.调用请求对象 读取 请求体 中的参数信息，得到用户的注册信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");


        //2.调用DAO类将用户信息条虫到INSERT命令并借助JDBC发送到数据库服务器中,返回结果
        user = new Users(null,userName,password,sex,email);
        result = dao.add(user);



        //3.调用响应对象将处理结果以二进制形式写入响应体,并在响应头中定义内容的type
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result == 1){
            out.print("<font style = 'color:red;font-size:50'>注册成功</font>");
        }else {
            out.print("<font style = 'color:red;font-size:50'>注册失败</font>");
        }




    }
        //tomcat负责销毁请求对象和响应对象
        //tomcat负责将http响应协议包发送到发起请求的浏览器上
        //浏览器根据响应头里的content-type指定的编译器对二进制内容进行编译
        //浏览器将结果编辑后结果在窗口中展示
}
