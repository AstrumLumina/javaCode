<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/28
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名: <input name="username" type="text"/>
        密码:   <input name="password" type="password"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
