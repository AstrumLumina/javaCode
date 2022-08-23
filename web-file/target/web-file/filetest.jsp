<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
get :文件大小有限制,大小很小,所以需要用post方法
post:
--%>

<form action="${pageContext.request.contextPath}/uploadfile.do" method="post" enctype="multipart/form-data">
    上传用户:<input type="text" name="username"> <br/>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file2"></p>
    <p>
        <input type="submit"/> | <input type="reset">
    </p>

</form>

</body>
</html>
