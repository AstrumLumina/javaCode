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
<%--<jsp:include page="/head.jsp" ></jsp:include>&lt;%&ndash;用于引入文件拼成一个网页&ndash;%&gt;--%>
<jsp:forward page="/tag.jsp">
    <%--设置转发 携带的参数--%>
   <jsp:param name="username" value="val1"/>
    <jsp:param name="psd" value="root"/>
</jsp:forward>
<%--转发标签--%>



</body>
</html>
