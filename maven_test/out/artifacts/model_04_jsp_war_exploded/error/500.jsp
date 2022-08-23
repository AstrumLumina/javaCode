<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/15
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<html>
<head>
    <title>Error500</title>
</head>
<body>

<%
    //原因：Tomcat将Iserror.jsp也认为出现了错误，所以无法显示。
    //解决办法：在Iserror.jsp中添加如下代码片段：
    response.setStatus(200);//状态码可以选择200-203
%>
<img src="../img/500.jpg" alt="500"/>


</body>
</html>
