<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    String s_user = (String) session.getAttribute("sessionUserName");
%>

<c:set var="s_user" value="<%=s_user%>"/>

<c:if test="${empty s_user}">
    <c:redirect url="/login.do"/>
</c:if>

<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/main.do">Home</a></li>
            <li><a href="/board.do">글목록</a></li>
            <c:if test="${not empty s_user}">
                <li><a href="/logout.do">로그아웃</a></li>
            </c:if>
        </ul>
        <h3 class="text-muted">메인</h3>
    </div>

    <div class="form-group">
        <c:if test="${empty s_user}">
            <c:redirect url="/login.do"/>
        </c:if>
        <h1>지옥자바</h1>
        <p>지옥자바 게시판 만들기 과제</p>
    </div>


</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
