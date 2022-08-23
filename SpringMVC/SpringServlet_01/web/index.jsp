<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/24
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--上这里法跳转--%>
  <form action="WEB-INF/jsp/hellow.jsp" method="get">
    <input type="submit"/>
  </form>

  <%--无法跳转,需要使用forward方式--%>
  <jsp:forward page="WEB-INF/jsp/hellow.jsp"></jsp:forward>

  </body>
</html>
