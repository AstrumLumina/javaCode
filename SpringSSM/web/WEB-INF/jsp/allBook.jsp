<%--
  Created by IntelliJ IDEA.
  User: XUANXIE
  Date: 2022/7/27
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>书籍列表</title>
    <%--bootStrap 美化界面  --%>


    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<%--    <!-- 可选的Bootstrap主题文件（一般不使用） -->--%>
<%--    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>--%>

<%--    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->--%>
<%--    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>

<%--    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
<%--    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>


</head>
<body>
<div class="container"><%--一个边框--%>
    <div class="row clearfix"><%--清除浮动--%>
        <div class="col-md-12 column"><%--将屏幕等分为12等分  分出12md大小的边框--%>
                <div class="page-header"><%--标题--%>
                    <h1>
                        <small>书籍列表----------显示所有书籍</small>
                    </h1>
                </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBookPage">新增书籍</a>
            </div>
            <div class="col-md-8-column">
                <%--查询书籍--%>
                <form action="${pageContext.request.contextPath}/book/booksLike" method="post">
                    <input type="text" name="bookName" class="form-select-button"
                           placeholder="请输入您要查询书籍的名称!"/>
                    <input type="submit" class="btn btn-primary" value="查询"/>
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix"><%--清除浮动--%>
        <div class="col-md-12 column"><%--将屏幕等分为12等分  分出12md大小的边框--%>
            <table class="table table-hover table-striped">
                <thead><%--头部--%>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>

                <tbody><%--内容 数据--%>
                        <c:forEach var="book" items="${requestScope.get('list')}">
                            <tr>
                                <td>${book.getBookID()}</td>
                                <td>${book.getBookName()}</td>
                                <td>${book.getBookCounts()}</td>
                                <td>${book.getDetail()}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/toUpdateBookPage?bookID=${book.getBookID()}">修改</a>
                                    &nbsp; | &nbsp;
                                    <a href="${pageContext.request.contextPath}/book/deleteBook?bookID=${book.getBookID()}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
