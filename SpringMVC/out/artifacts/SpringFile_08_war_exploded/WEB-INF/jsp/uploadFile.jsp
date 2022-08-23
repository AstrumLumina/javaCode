<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/29
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
