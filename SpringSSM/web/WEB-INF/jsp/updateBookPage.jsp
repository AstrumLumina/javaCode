<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <div class="form-group">
            <label for="bookID">书籍编号</label>
            <input readonly name="bookID" type="text" class="form-control" id="bookID" value="${book.getBookID()}"/>
        </div>
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input required name="bookName" type="text" class="form-control" id="bookName" value="${book.getBookName()}"/>
        </div>
        <div class="form-group">
            <label for="bookAcount">书籍数量</label>
            <input required name="bookCounts" type="number" class="form-control" id="bookAcount" value="${book.getBookCounts()}"/>
        </div>
        <div class="form-group">
            <label for="bookDetail">书籍介绍</label>
            <input required name="detail" type="text" class="form-control" id="bookDetail" value="${book.getDetail()}"/>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="提交修改"/>
        </div>
    </form>
</div>
</body>
</html>
