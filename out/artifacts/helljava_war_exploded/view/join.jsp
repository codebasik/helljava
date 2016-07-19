<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">
    <title>회원가입완료</title>
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/resources/assets/js/html5shiv.js"></script>
    <script src="/resources/assets/js/respond.min.js"></script>
</head>

<%
    String userName = (String) request.getAttribute("userName");
    String loginUserName = (String) session.getAttribute("userName");
    session.setMaxInactiveInterval(5);             //로그인시간 60초
%>

<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/view/main.jsp">Home</a></li>
            <% if (loginUserName != null) {%>
            <li><a href="/logout.do">로그아웃</a></li>
            <%}%>
        </ul>
        <h3 class="text-muted">회원가입완료</h3>
    </div>

    <div class="form-group">
        <%=userName%>님 회원가입을 축하합니다.
        <%=loginUserName%>
    </div>

</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
