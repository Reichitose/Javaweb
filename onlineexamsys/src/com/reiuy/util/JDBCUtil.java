package com.reiuy.util;

import java.sql.*;

/**
 *
 *  将JDBC规范下相关的对象【创建】和【销毁】功能封装到方法
 *
 *  一。JDBC开发步骤
 *      1.注册数据库提供的Driver接口类
 *      2.创建一个连接通道交给Connection接口的实例对象JDBC4Connection管理
 *      3.创建一个交通工具交给PreparedStatement接口的实例对象JDBD4PreparedStatement管理
 *      4.由交通工具在java工程与数据服务期之间进行传输，推送SQL命令并带回执行结果
 *      5.交易结束后，关闭并销毁相关资源
 *
 */
public class JDBCUtil {

    private Connection con = null;      //类文件的属性在当前所有方法中可以使用
    private PreparedStatement ps = null;

    //静态语句块static{}
    //在当前类文件第一次被加载到JVM时，JVM将会自动调用当前类文件静态语句块

    static{
        //1.注册数据库提供的Driver接口类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver注册成功");
    }

    // 2.封装Connection对象的创建细节
    public Connection creatCon(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reiuy","root","123123");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection对象创建失败...");
        }
        return con;

    }
    //封装PreparedStatement对象的创建细节
    public PreparedStatement createStatement(String sql){

        Connection con = creatCon();
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }


    //封装PreparedStatement对象与Connection对象销毁细节
    public void close(){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(con != null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //封装PreparedStatement对象，Connection对象和ResultSet对象销毁细节
    public void close(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }
}
