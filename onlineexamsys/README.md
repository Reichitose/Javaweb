# topic
通过JDBC的工具类以及Dao类和Servlet实现了简单的系统

完成了简单的
    用户信息注册
    用户信息查询
    用户信息删除
    用户信息更新
    功能


用户信息表User如下
    
    
    CREATE TABLE Users(


        userId int primary key auto_increment,      #用户id
        userName varchar(50),                       #用户名称
        password varchar(50),                       #用户密码
        sex char(1),                                #用户性别‘男’or‘女’
        email varchar(50),                          #用户邮箱

    )
