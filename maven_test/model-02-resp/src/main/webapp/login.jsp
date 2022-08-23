<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/15
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1 style="text-align: center">登录</h1>
<div style="text-align: center" >
    <form method="post" action="${pageContext.request.getContextPath()}/login">
        用户名:<input type="text" name="username" placeholder="用户名"/><br/>
        密码 : <input type="password" name="password" placeholder="密码"></input><br/>
        爱好 :<input type="checkbox" name="hobbys" value="girl"/>girl
        <input type="checkbox" name="hobbys" value="programing" />编程
        <input type="checkbox" name="hobbys" value="sleep" />睡觉
        <input type="checkbox" name="hobbys" value="study"/>学习
        <br/>
        <input type="submit" value="登录"/>
    </form>
</div>

</body>
</html>
