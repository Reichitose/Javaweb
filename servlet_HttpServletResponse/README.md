# 内容
关于HttpServletResponse中响应对象

# 笔记
## HttpServletResponse接口

1.来自于servlet规范
2.接口实现类由http服务器提供
3.负责将doGet/doPost方法的执行结果写入到响应体中交给浏览器
4.习惯上将HttpServletResponse接口修饰的对象称为响应对象

## 功能

1.将执行结果以二进制形式写入响应体

通过响应对象获得输出流，并通过print方法写入响应体

2.设置响应头中[content-type]属性值，控制浏览器用响应的编译器将二进制数据文件编译为文字图片视频和命令

3.设置location可以重定向响应访问的地址

