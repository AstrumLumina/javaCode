<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/28
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajaxTest</title>

    <script src="${pageContext.request.contextPath}/statics/jquery-3.6.0.min.js"></script>
    <script>
        function test1() {sss

            var username= $("#username").value;//错误,不能拿到值
            username = jQuery("#username").val();//可以拿到值
            /*这种写法报错,导致js代码卡死再者,导致这个以及后面的含数都不能被识别为函数*/
            $.post({
                url:"${pageContext.request.contextPath}/a3",
                data:{'username':$("#username").val()},
                success:function (status,data){
                    alert(status);
                    $("#nameInfo").html(data);
                }
            });
        }
    </script>
    <script>
        function verifyName(){
            var username = jQuery("#username").val();
            $.post({
                url:"${pageContext.request.contextPath}/a3",
                data:{'name':username},
                success:function (data){
                    if(data==="ok"){
                        $("#nameInfo").css("color","green");
                    }else{
                        $("#nameInfo").css("color","red");
                    }
                    $("#nameInfo").html(data);
                }
            });
        }
    </script>
    <script>
        function verifyPwd(){
            var password=$("#password").val();
            jQuery.post(
                "${pageContext.request.contextPath}/a3",
                {"pwd":password},
                function (data){
                    if(data==="ok"){
                        $("#pwdInfo").css("color","green");
                    }else{
                        $("#pwdInfo").css("color","red");
                    }
                    $("#pwdInfo").html(data);
                });
        }
    </script>

</head>
<body>
<p>
    用户名<input type="text" id="username" name="username" onblur="verifyName()" value="username"/>
    <span id="nameInfo"></span>
</p>
<p>
    密码<input type="password" id="password" onblur="verifyPwd()" value="111111"/>
    <span id="pwdInfo"></span>
</p>

</body>
</html>
