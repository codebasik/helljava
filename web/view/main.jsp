<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">
    <title>메인</title>
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/resources/assets/js/html5shiv.js"></script>
    <script src="/resources/assets/js/respond.min.js"></script>
</head>

<%
    String loginUserName = (String) session.getAttribute("userName");
%>

<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/view/main.jsp">Home</a></li>
            <li><a href="#">글목록</a></li>
            <% if (loginUserName != null) {%>
            <li><a href="/logout.do">로그아웃</a></li>
            <%}%>
        </ul>
        <h3 class="text-muted">메인</h3>
    </div>

    <div class="form-group">
        <%
            if (loginUserName == null) {
                response.sendRedirect("/login.do");
            }
        %>

        <%=loginUserName%>님 로그인중
    </div>

</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
