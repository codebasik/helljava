<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">
    <title>회원가입</title>
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/resources/assets/js/html5shiv.js"></script>
    <script src="/resources/assets/js/respond.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="header">
            <ul class="nav nav-pills pull-right">
                <li class="active"><a href="/view/main.jsp">Home</a></li>
            </ul>
            <h3 class="text-muted">회원 가입</h3>
        </div>
        <form role="form" action="/join.do" method="post">
            <div class="form-group">
                <label for="userName">이름</label>
                <input type="text" name="username" class="form-control" id="userName" placeholder="이름을 입력하세요">
            </div>
            <div class="form-group">
                <label for="userPassword">비밀번호</label>
                <input type="password" name="userpassword" class="form-control" id="userPassword" placeholder="비밀번호를 입력하세요">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
