<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--获取转发过来的参数--%>
<%
    String name = request.getParameter("username");
    String psd = request.getParameter("psd");
%>
name:${name}
password:${psd}


</body>
</html>
