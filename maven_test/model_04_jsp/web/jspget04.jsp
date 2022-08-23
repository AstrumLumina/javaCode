<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String name1 = (String)pageContext.getAttribute("name1");
    String name2 = (String)pageContext.getAttribute("name2");
    String name3 = (String)pageContext.getAttribute("name3");
    String name4 = (String)pageContext.getAttribute("name4");
    String name6 = (String)pageContext.getAttribute("name6");//不存在,返回空
%>
<%-- ${}  EL 表达式 --%>
<h2>${name1}</h2>
<h2>${name2}</h2>
<h2>${name3}</h2>
<h2>${name4}</h2>
<h2>${name6}</h2>
<%="*******查看区别******"%>
<br/>
<%=name6%>

</body>
</html>
