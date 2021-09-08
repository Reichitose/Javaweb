package com.reiuy.controller;

import java.io.IOException;

/**
 *   servlet对象生命周期
 *      1.原则上网站中所有的servlet接口实现类的实例对象，只能由Http服务器负责创建，开发人员不能手动创建servlet接口实现类的实例对象
 *
 *      2.在默认的情况下，Http服务器接收到对于当前servlet接口实现类的第一次请求时，自动创建这个servlet接口实现类的实例对象
 *
 *      手动配置时，可以要求Http服务器在启动时自动创建某个Servlet接口实现类的实例对象
 *      方法如下
 *      <servlet>
 *           <servlet-name>path</servlet-name>   <!--声明一个变量用于储存servlet接口实现类的类路径-->
 *           <servlet-class>com.reiuy.controller.OneServlet</servlet-class> <!--声明servlet接口实现类的类路径-->
 *           <load-on-startup>1</load-on-startup>   <!--此处默认值为0，故只需填写一个大于0的整数即可-->
 *      </servlet>
 *
 *
 *      3.在Http服务器运行期间，一个servlet接口实现类只能被创建出一个实例对象，一次请求（线程）只会有一个实例对象（进程），无
 *      数次请求也只会有一个实例对象，一个进程对应多个线程
 *
 *      4.在Http服务器关闭的时刻，会自动将网站中所有的servlet对象进行销毁
 *
 *
 **/

public class OneServlet extends jakarta.servlet.http.HttpServlet {
    public OneServlet() {
        System.out.println("OneServlet类被创建实例对象");
    }

    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        System.out.println("OneServlet doGet is running...");
    }
}
