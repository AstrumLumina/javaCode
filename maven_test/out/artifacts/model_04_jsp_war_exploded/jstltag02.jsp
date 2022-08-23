<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--如果el表达式无效，可能是默认禁止了el表达式，可按如下开启--%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> people =new ArrayList<>();
    people.add(0,"张三");
    people.add(1,"李四");
    people.add(2,"王五");
    people.add(3,"老六");
    people.add(4,"田七");
    request.setAttribute("username",people);
%>
<c:forEach var="person" items="${username}">
    <c:out value="${person}"/>
    <br/>
</c:forEach>
<hr/>
<c:forEach var="person" items="${username}" begin="0" step="2">
    <c:out value="${person}"/>
    <br/>
</c:forEach>

<%--测试el表达式--%>
<c:set value="8" var="tempval"></c:set>
<c:out value="${tempval}"></c:out>
</body>
</html>
