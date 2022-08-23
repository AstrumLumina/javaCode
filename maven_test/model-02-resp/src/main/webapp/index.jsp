
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.getContextPath()}/dealrequest" method="get"><br/>
    用户名:<input type="text" name="username" /><br/>
    密码 :<input type="password" name="psd" /><br/>
    <input type="submit">
</form>

</body>
</html>
