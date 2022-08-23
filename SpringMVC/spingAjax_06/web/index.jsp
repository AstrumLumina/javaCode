<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/28
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script>
      function go(){
        var url=document.getElementById("url").value;
        document.getElementById("iframe").src=url;
      }
    </script>



  </head>
  <body>
  <h1>iframe测试</h1>
  <p>
    <input type="text" name="url" id="url">
    <input type="submit" value="加载" onclick="go()">
  </p>
<iframe id="iframe" src="" frameborder="0" style="width:50%;height:300px">
  <p>
    <a href="${pageContext.request.contextPath}/ajax1">获取 数据</a>
  </p>
</iframe>
  </body>
</html>
