<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--内置对象--%>
<%
pageContext.setAttribute("name1","val1");/*相当于当前页面*/ //数据只在一个里页面有效
request.setAttribute("name2","val2");//只在一次请求中有效
session.setAttribute("name3","val3");//只在一次会话中有效,浏览器打开到关闭
application.setAttribute("name4","val4");/*相当于servletContext*/
//只在服务器中有效,从打开服务器到关闭服务器
    /*config:相当于servetconfig*/

    //如果再次这使用forward从其他页面获取req作用域的数据,则可以获取,
    // 还是原来的请求
    pageContext.forward("/jspget04.jsp");

%>
<%--通过内置对象 获取存入的东西--%>
<%--注意作用域  从底层到高层查找获取:
page->session->application
,若作用域不能拿到,会返回null--%>
<%--作用域不足时,可以设置强行提高作用域,但不推荐--%>
<%

    pageContext.setAttribute("name6","val6",PageContext.SESSION_SCOPE);//设置作用域为 session
    String name1 = (String)pageContext.getAttribute("name1");
    String name2 = (String)pageContext.getAttribute("name2");
    String name3 = (String)pageContext.getAttribute("name3");
    String name4 = (String)pageContext.getAttribute("name4");
    String name5 = (String)pageContext.getAttribute("name5");//不存在,返回空

%>
<%-- ${}  EL 表达式 --%>
<h2>${name1}</h2>
<h2>${name2}</h2>
<h2>${name3}</h2>
<h2>${name4}</h2>
<h2>${name5}</h2>
<%="*******查看区别******"%>
<br/>
<%=name5%>
<%--EL表达式不会输出空值,当正常的Java代码会--%>


</body>
</html>
