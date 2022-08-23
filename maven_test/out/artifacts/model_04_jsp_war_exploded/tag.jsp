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
<jsp:include page="/head.jsp" ></jsp:include>

<%--获取转发过来的参数--%>
<%
    String name = request.getParameter("username");
    String psd = request.getParameter("psd");
%>
<h2>这里是forward跳转后 的页面</h2>
这里是forward跳转后 的页面
<br/>
name:${name}<br/><%--这样不能取出该值--%>
password:${psd}<br/>
name:<%=name%><br/>
password:<%=psd%>


</body>
</html>
