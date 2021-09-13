package com.reiuy.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 *
 *
 * ###########################以下是关于监听器###################################
 *关于监听器
 *      1.一组来源于Servlet规范下的接口，总共有八个，存在于tomcat中的servlet-api.jar中
 *      2.监听器接口需要开发人员亲自实现，Http服务器提供的jar包没有对应的实现类
 *      3.监听器接口主要用于监控【作用域对象生命周期的变化时刻】和【作用域对象共享数据变化时刻】
 *
 *关于作用域对象
 *      1.在servlet规范中，认为在服务端内存中可以在某些条件下为两个Servlet之间提供数据共享方案的对象
 *        叫做作用域对象，由于是服务端内存中，故Cookie虽然可以实现两个Servlet之间的数据共享，却因为存
 *        放在浏览器内存中，仍然不算作用域对象
 *
 *      2.Servlet下作用域对象有三个
 *          ServletContext        全局作用域对象    *针对同一个web项目/web应用，只要服务器不关，数据一直是有效的
 *          HttpSession           会话作用域对象    *针对同一次会话，一般存放用户信息，只在一次回话中有效
 *          HttpServletRequest    请求作用域对象    *针对同一次请求，一般存放提示信息，只在一次请求中有效
 *
 *
 *关于监听器的开发
 *      1.根据监听的实际情况，选择对应的监听器接口进行实现
 *      2.重写监听器接口中声明 的 监听事件处理方法
 *      3.去web.xml文件中注册监听器接口实现类到Http服务器上
 *
 *     <!--将监听器接口实现类注册到tomcat-->
 *     <listener>
 *         <listener-class>com.reiuy.listener.OneListener</listener-class>
 *     </listener>
 *
 *
 * ####################以下是关于ServletContextListener接口####################
 *
 * 关于ServletContextListener
 *
 *      作用是可以通过这个接口合法的检测全局作用域对象被初始化的时刻和被销毁的时刻
 *      对应着 监听【作用域对象生命周期的变化时刻】
 *
 *
 *
 *      分别是
 *          public void contextInitialized(ServletContextEvent sce){
 *
 *          }
 *             //在全局作用域对象被Http服务器初始化时调用
 *
 * ----------------------------------------------------------------------------
 *
 *          public void contextDestroyed(ServletContextEvent sce){
 *
 *          }
 *               //在全局作用域对象被Http服务器销毁时调用
 *
 *
 *
 *
 *
 */





public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局作用对象被初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局作用域对象被销毁...");
    }
}
