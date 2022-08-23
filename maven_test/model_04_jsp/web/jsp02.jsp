<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/15
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %><%--导包, 也会自动导包--%>

<%--定制错误页面--%>
<%@  page errorPage="error/500.jsp" %>



<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 使用errorPage设置无效:
那么就是错误类型问题了。

错误是语法错误，这种错误是不会跳转的。

只有Exception才能跳转，比如下面这个jsp页面就可以。--%>
<%
  int i=10/0;//除数为0 ,会报错
%>
<%--这个页面不会跳转,但在web.xml设置可以解决此问题,而且更灵活精确--%>
<% =new Date()%>

</body>
</html>
