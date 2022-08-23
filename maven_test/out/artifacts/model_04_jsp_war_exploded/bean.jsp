<%@ page import="com.xuanxie.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/16
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    People people1 = new People();
  //  People people2 = new People();
    People people3 = new People();
    people1.setAddress("whut");
    people1.setAge(14);
    people1.setId(1);
    people1.setName("tom");
%>

<%--需要先声明再使用--%>
<jsp:useBean id="people2" class="com.xuanxie.pojo.People" scope="page"/>
<%--赋值--%>
<jsp:setProperty name="people2" property="name"  value="petter"/>
<jsp:setProperty name="people2" property="id"  value="2"/>
<jsp:setProperty name="people2" property="address"  value="whut"/>
<jsp:setProperty name="people2" property="age"  value="20"/>
<hr/>
<%--取值，这种方式只能取以这种方式定义的变量--%>
姓名：<jsp:getProperty name="people2" property="name"/>
地址：<jsp:getProperty name="people2" property="address"/>
年龄：<jsp:getProperty name="people2" property="age"/>
id：<jsp:getProperty name="people2" property="id"/>
<hr/>
<%--这种方式可以取多种方式定义的变量的值--%>
姓名：<%=people2.getName()%>
地址：<%=people2.getAddress()%>
年龄：<%=people2.getAge()%>
id：<%=people2.getId()%>
<hr/>
姓名：<%=people1.getName()%>
地址：<%=people1.getAddress()%>
年龄：<%=people1.getAge()%>
id：<%=people1.getId()%>
<hr/>
姓名：<%=people3.getName()%>
地址：<%=people3.getAddress()%>
年龄：<%=people3.getAge()%>
id：<%=people3.getId()%>



</body>
</html>
