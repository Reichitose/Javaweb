package com.reiuy.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 关于过滤器Filter
 *      1.来自servlet规范下，在tomcat中存在于servlet-api.jar
 *      2.Filter接口实现类由开发人员负责提供，Http服务器不提供
 *      3.Filter接口在Http服务器调用资源之前，进行拦截
 *
 * 关于作用
 *      1.拦截Http服务器，帮助Http服务器检查当前请求的合法性
 *      2.拦截Http服务器，对当前请求进行加强
 *
 *关于开发步骤
 *      1.创建Filter接口实现类
 *      2.重写Filter接口中的doFilter方法
 *      3.在web.xml文件中注册
 *
 *
 *
 *关于实际使用
 *      1.详见代码OneFilter，拦截请求对象中的参数信息，了解请求是否合法，并代替Http服务器返回拒绝请求
 *      2.详见代码TwoFilter，通过拦截，增强请求后发出，例如对post方法进行预编码，从而使得
 *      编写doPost方法时不用预编码防止中文乱码
 *
 *
 *
 *关于使用格式
 *      见代码和web.xml文件
 *
 * http://localhost:8080/servlet_filter/xb2.jpg?name=20
 */


public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.通过拦截的请求对象得到请求包中的参数信息，从而得到来访用户的真实情况
        String name = servletRequest.getParameter("name");
        //2.根据参数name判断请求的合法性
        if (Integer.valueOf(name) == 20) { //合法请求
            //将拦截的请求和响应对象放行给tomcat
            filterChain.doFilter(servletRequest, servletResponse);//通过filterChain放行
        } else {
            //过滤器代替Http服务器拒绝请求
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.print("<center>您不是xb2的粉丝！</center>");
        }
    }
    //filterChain负责放行请求
}
