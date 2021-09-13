package com.reiuy.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class TwoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    //通知我们拦截的请求对象，使用utf8编码对通过post获得的请求体进行重新编辑
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
