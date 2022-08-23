<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--需要引入相应的包才能使用jstl核心标签库 core --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>jstl标签使用</h2>
if测试
<br/>
<form action="jstltag.jsp" method="get">
    <%--El表达式获取表单的数据：
    ${param.参数名}
    --%>
    <input type="text" name="username" value="${param.username}">
<input type="submit" value="登录">

</form>
<%
    if(request.getParameter("username").equals("root")){
        out.println("登录成功");
    }
%>
<br/>
<%--使用标签代替--%>
<c:if test="${param.username=='root'}"  var="isroot" >
    <c:out value="欢迎登录！！！"></c:out>
</c:if>
<c:out value="${isroot}"></c:out>
<%--定义一个变量score，值为80--%>
<c:set var="score" value="80"/>
<br/>
你的成绩等级为：<br/>
<%--相当于if else 遇到满足条件的会截断--%>
<c:choose>
    <c:when test="${score>=85}">
        你的成绩为优秀
    </c:when>
    <c:when test="${score>=60}">
        你的成绩为优秀
    </c:when>
    <c:when test="${score<60}">
        你的成绩不及格
    </c:when>
</c:choose>
<br/>
你的成绩分数为：
<c:out value="${score}"></c:out>

</body>
</html>
