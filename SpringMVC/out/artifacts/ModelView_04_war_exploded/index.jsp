<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/26
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  重定向:带来的参数数 ${msg}

  <form action="./restful/4/5" method="post">
    <input type="number" name="a"/>
    <input type="number" name="b"/>
    <input type="submit" />
  </form>
  </body>

  <form action="./dealparam" method="post">
    <input type="text" name="username"/>
    <input type="submit" />
  </form>
  </body>
</html>
