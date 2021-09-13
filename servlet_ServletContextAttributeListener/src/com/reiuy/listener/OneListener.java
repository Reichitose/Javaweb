package com.reiuy.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jdk.swing.interop.SwingInterOpUtils;

/**
 *####################以下是关于ServletContextAttributeListener接口####################
 *
 *关于ServletContextAttributeListener接口
 *
 *        作用是可以通过这个接口合法的检测全局作用域中的共享数据变化的时刻
 *        对应着【作用域对象共享数据变化时刻】
 *
 *
 *        分别是
 *
 *          public void attributeAdded(ServletContextAttributeEvent scae) {
 *
 *          }
 *              //在全局作用域对象添加共享数据时被调用
 *-------------------------------------------------------
 *        public void attributeReplaced(ServletContextAttributeEvent scae){
 *
 *        }
 *              //在全局作用域对象更新共享数据时被调用
 *-------------------------------------------------------
 *        public void attributeRemoved(ServletContextAttributeEvent scae){
 *
 *        }
 *             //在全局作用域对象删除共享数据时被调用
 *
 *关于全局作用域对象共享数据变化时刻
 *
 *        ServletContext application = request.getServletContext();
 *        //向tomcat所要并得到当前网站的全局作用域对象
 *
 *        application.setAttribute("key",value1);    //此时新增共享数据
 *
 *        application.setAttribute("key",value2);    //此时更新共享数据 value1->value2
 *
 *        application.removeAttribute("key");        //此时删除了共享数据
 *
 *
 *
 */




public class OneListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {

        System.out.println("新增了共享数据...");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

        System.out.println("删除了共享数据...");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

        System.out.println("更新了共享数据...");
    }
}
