<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<title>로그인</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/resources/assets/js/html5shiv.js"></script>
    <script src="/resources/assets/js/respond.min.js"></script>
</head>

<body>

<%
    String s_user = (String) session.getAttribute("sessionUserName");
%>


<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/main.do">Home</a></li>
        </ul>
        <h3 class="text-muted">글쓰기</h3>
    </div>
    <form role="form" action="/write.do" method="post">
        <div class="form-group">
            <label for="username">이름</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="이름을 입력하세요" required>
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력하세요" required>
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" rows="4" id="content" name="content" placeholder="내용을 입력하세요" required></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
