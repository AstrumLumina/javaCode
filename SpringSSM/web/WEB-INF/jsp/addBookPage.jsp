<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增书籍</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input required name="bookName" type="text" class="form-control" id="bookName" placeholder="书籍名称"/>
        </div>
        <div class="form-group">
            <label for="bookAmount">书籍数量</label>
            <input required name="bookCounts" type="number" class="form-control" id="bookAmount" placeholder="bookAmount"/>
        </div>
        <div class="form-group">
            <label for="bookDetail">书籍介绍</label>
            <input required name="detail" type="text" class="form-control" id="bookDetail" placeholder="bookDetail"/>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加"/>
        </div>
    </form>
</div>
</body>
</html>
