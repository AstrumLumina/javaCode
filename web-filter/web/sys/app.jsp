<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/17
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--防止未登登录用户直接进入主页 的方法1--%>
<%--<%
    Object userSession = request.getSession().getAttribute("USE_SESSION");
    if(userSession==null){
        pageContext.forward("/");
    }
%>--%>
<h1>登录成功,欢迎来到主页</h1>

<p><a href="/f/servlet/loginout">注销</a> </p>
</body>
</html>
