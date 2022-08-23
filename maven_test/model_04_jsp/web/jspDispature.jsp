<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
pageContext.forward("/index.jsp");//等价于下面部分,可以简化代码
//request.getRequestDispatcher("/index.jsp").forward(request,response);
%>

</body>
</html>
