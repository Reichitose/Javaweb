package com.reiuy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet接口实现类开发流程
 *  1.创建java类继承自HttpServlet父类，使其成为Servlet接口实现类
 *
 *  2.重写HttpServlet父类的两个方法，doGet和doPost
 *
 *  3.将servlet接口实现类信息“注册”到tomcat服务器
 *      WEB----WEB-INF--->web.xml
 *      <!--将servlet接口实现类类路径地址交给tomcat-->
 *      <servlet>
 *          <servlet-name>path</servlet-name>   <!--声明一个变量用于储存servlet接口实现类的类路径-->
 *          <servlet-class>com.reiuy.controller.OneServlet</servlet-class> <!--声明servlet接口实现类的类路径-->
 *      </servlet>
 *
 *      此时tomcat中：
 *      String path = “com.reiuy.controller.OneServlet”
 *
 *
 *      <!--为了降低用户访问servlet接口实现类的难度，需要设置一个简单的请求别名-->
 *      <servlet-mapping>
 *          <servlet-name>path</servlet-name>
 *          <url-pattern>/one</url-pattern>     <!--设置简短的请求别名，书写时必须以/开始-->
 *      </servlet-mapping>
 *
 *
 *
 *
 * 子类继承自父类,父类实现A接口
 * 子类也是A接口的实现类
 *
 *
 * 抽象类的作用：降低接口类对接口实现过程中的难度
 *             将接口不需要使用的抽象方法交给抽象类进行完成。只需要对需要的方法进行重写
 *
 *
 *             init
 *             getServletConfig
 *             getServletInfo
 *             destroy   这四个方法对于Servlet接口实现类没用
 *             只有service有用
 *
 *
 * Tomcat根据Servlet规则调用Servlet接口实现类规则：
 *              1.Tomcat有权创建Servlet接口实现类的实例对象
 *              Servlet oneServlet = new OneServlet();
 *              2.Tomcat根据实例对象调用service方法处理请求
 *              oneServlet.service()，此时service方法中的this指向oneServlet
 *
 *
 * 继承关系
 *          oneServlet--extends-->(abstract)HttpServlet--extends-->(abstract)GenericServlet--implement-->Servlet接口
 *                                                                                |
 *                                                           (实现init destroy getServletInfo getServletConfig)
 *
 *
 *
 *
 * 通过父类决定在何种情况下调用子类中的方法在设计模式中叫模板设计模式
 * HttpServlet：service(){
 *     if(请求方式 == GET({
 *         this.doGet
 *     }else if(请求方式 == POST){
 *         this.doPost
 *     }
 *     doGet
 *     doPost
 * }
 *
 * 故OneServlet中： doGet doPost
 * Servlet oneServlet = new OneServlet();
 * oneServlet.service()
 *
 */


public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送的Get请求方式");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送的Post请求方式");
    }
}
