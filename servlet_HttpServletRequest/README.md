# 内容
关于HttpServletRequest接口

# 笔记

## HttpServletRequest接口

### 介绍

1. HttpServletRequest接口来自于servlet规范，在servlet-api.jar中
2. HttpServletRequest接口实现类由Http服务器提供
3. HttpServletRequest接口负责在doGet/doPost方法运行时读取Http请求协议包中的信息
4. HttpServletRequest接口所修饰的对象称为**请求对象**

### 作用

1. 可以读取Http请求协议包中**请求行**的信息

2. 可以读取保存在Http请求协议包中请求行中的请求参数信息

   	**这里注意**，无论是get还是post，请求参数信息均在请求行中，get因为参数直接拼接在url里，故位于请求行中的请求url中，不在请求头中

3. 可以替代浏览器向Http服务器申请资源文件调用
