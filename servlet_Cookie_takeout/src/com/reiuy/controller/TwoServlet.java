package com.reiuy.controller;

import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        int dumpling_money = 30;
        int noodle_money = 20;
        int rice_money = 15;

        String food,userName = "";
        Cookie cookieArray[] = null;
        int money = 0;
        int cost = 0; //消费了多少
        PrintWriter out = response.getWriter();
        Cookie newCard = null;
        response.setContentType("text/html;charset=utf-8");
        //1.读取请求头的参数信息得到用户想要点的食物
        food = request.getParameter("food");
        //2.读取请求头中的Cookie
        cookieArray = request.getCookies();
        //3.刷卡消费
        for (Cookie card : cookieArray) {
            String key = card.getName();
            String value = card.getValue();
            if ("userName".equals(key)) {
                userName = value;
            } else if ("money".equals(key)) {
                money = Integer.parseInt(value);
                if ("饺子".equals(food)) {
                    if (dumpling_money > money) {
                        out.print("用户" + userName + "余额不足，请充值");
                    } else {
                        newCard = new Cookie("money", (money - dumpling_money) + "");
                        cost = dumpling_money;
                    }
                } else if ("面条".equals(food)) {
                    if (noodle_money > money) {
                        out.print("用户" + userName + "余额不足，请充值");
                    } else {
                        newCard = new Cookie("money", (money - noodle_money) + "");
                        cost = noodle_money;
                    }
                } else if ("米饭".equals(food)) {
                    if (rice_money > money) {
                        out.print("用户" + userName + "余额不足，请充值");
                    } else {
                        newCard = new Cookie("money", (money - rice_money) + "");
                        cost = rice_money;
                    }
                }
            }

        }
        //4.将会员卡返还给用户
        response.addCookie(newCard);
        //5.将消费记录写入响应体
        out.print("用户"+userName+"本次消费"+cost);

    }
}
