<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/28
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/jquery-3.6.0.min.js"></script>
    <script>
        function getUsers(){
            $.post(
                "${pageContext.request.contextPath}/getUsers",
                function (data){
                    var html="";
                    /*+"&nbsp;&nbsp;"*/
                    for(let i=0;i<data.length;++i){
                        html+="<tr>"
                            +"<td>" +data[i].name +"&nbsp;&nbsp;"+"</td>"
                            +"<td>" +data[i].sex +"&nbsp;&nbsp;"+"</td>"
                            +"<td>" +data[i].age +"&nbsp;&nbsp;"+"</td>"
                            +"</tr>";
                    }
                    alert(html);
                    $("#user-name-label").html(html);
                }
            );
        }
    </script>
</head>
<body>
<h1>用户列表</h1>
<p><input type="submit" value="加载数据" onclick="getUsers()"/></p>
    <table>
        <tr>
            <td>姓名</td>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <td>性别</td>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <td>年龄</td>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </tr>
        <tbody id="user-name-label">

        </tbody>
    </table>



</body>
</html>
