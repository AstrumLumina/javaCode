<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这里是标签测试页面</h1>
<jsp:include page="/head.jsp" ></jsp:include>
<%--用于引入文件拼成一个网页--%>

<%--转发标签--%>
<%--设置转发 携带的参数--%>
<jsp:forward page="/tag.jsp">
   <jsp:param name="username" value="val1"/>
    <jsp:param name="psd" value="root"/>
</jsp:forward>
<%--forward标签内不能有注释，否则报错500 --%>





</body>
</html>
