package com.reiuy.controller;

import java.io.IOException;

public class TwoServlet extends jakarta.servlet.http.HttpServlet {
    public TwoServlet() {
        System.out.println("TwoServlet实例对象被创建了");
    }

    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        System.out.println("TwoServlet doGet is running...");
    }
}
