<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/26
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>首页</title>
  <style type="text/css">
    a{
      text-decoration: none;
      color: black;
      font-size: 21px;
    }
    h3{
      width: 180px;
      height: 37px;
      margin:100px auto;
      text-align: center;
      background: deepskyblue;
      border-radius: 4px;
    }
  </style>

</head>
<body>

<h3>
  <a href="${pageContext.request.contextPath}/book/allBook">查看所有书籍</a>
</h3>
</body>
</html>

