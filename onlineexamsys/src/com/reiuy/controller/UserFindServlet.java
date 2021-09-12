package com.reiuy.controller;

import com.reiuy.dao.UserDao;
import com.reiuy.entity.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {


        //1.调用DAO将查询命令推送到数据库服务器上来得到所有的用户信息
        UserDao dao = new UserDao();
        PrintWriter out;
        List<Users> userList = dao.findAll();

        //2.调用相应对象 将用户信息结合table命令以二进制形式写入响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
        for(Users users:userList){
            out.print("<tr>");
            out.print("<td>"+users.getUserId()+"</td>");
            out.print("<td>"+users.getUserName()+"</td>");
            out.print("<td>******</td>");
            out.print("<td>"+users.getSex()+"</td>");
            out.print("<td>"+users.getEmail()+"</td>");
            out.print("<td><a href='/onlineexamsys/user/delete?userId="+users.getUserId()+"'>删除用户</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");

    }
}
