package com.reiuy.controller;

import com.reiuy.dao.UserDao;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String userId;
        UserDao dao = new UserDao();
        int result = 0;
        PrintWriter out = null;
        //1.调用请求对象读取请求头中的参数 即用户编号
        userId = request.getParameter("userId");
        //2.调用Dao将用户编号填充到delete命令中并发送到数据库服务器
        result = dao.delete(userId);
        //3.调用相应对象并将结果以二进制写入响应体并交给浏览器
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result == 1){
            out.print("<font style = 'color:red;font-size:50'>删除成功</font>");
        }else{
            out.print("<font style = 'color:red;font-size:50'>删除失败</font>");
        }

    }
}
