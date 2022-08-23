<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/6/15
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--jsp表达式--%>
  <%=new java.util.Date()%>
<hr/>
  <%--jsp脚本判断--%>
  <%
  int sum=0;
  for(int i=0;i<100;++i){
    sum+=i;
  }
  out.println("<h1>sum="+sum+"</h1>");
  %>

  <%--脚本代码在实现--%>
<%
    int x=10;
    out.println(x);
%>
<p>这里是一个jsp文档</p>
  <%
      //int x=10;//上面已经定义了,不能重复定义
    int y=20;
    out.println("Y="+y);
  %>
<hr/>

  <%--在代码中嵌入HTML代码--%>
<%
    for(int i=0;i<10;++i){
%>
  <h1>hello wold 第 <%=i%> 次 </h1>
<%
  }
%>

  <%--jsp声明,不会放到方法里面,生成到Java类中,有更大的作用域
      其他的多会生成到方法里面
  --%>
<%!
  //jspse'h'g'n'm
    static{
          System.out.println("loading Servlet!!!");
    }
    private int globalver=0;
    public void f(){
      System.out.println("进入了jsp里为Java定义的方法");
    }
%>


  <%-- $ EL表达式 用于简化Java代码 --%>
  <%for(int i=0;i<10;++i){%>
  <h1>hello wold 第 ${i} 次 </h1>
  <%} %>

  </body>
</html>
