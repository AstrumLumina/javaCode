<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/17
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>当前网页有
    <span>
        <%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%>
        人在线
    </span>
</h1>


</body>
</html>
