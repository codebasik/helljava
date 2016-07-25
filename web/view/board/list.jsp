<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>글목록</title>
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

<c:set var="s_user" value="<%=s_user%>"/>

<c:if test="${empty s_user}">
    <c:redirect url="/login.do"/>
</c:if>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/">Home</a></li>
            <c:if test="${not empty s_user}">
                <li><a href="/logout.do">로그아웃</a></li>
            </c:if>
        </ul>
        <h3 class="text-muted">글목록</h3>
    </div>
    <div>
        <div>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" name="memberName" class="form-control" placeholder="회원명"
                           value="${orderSearch.memberName}">
                </div>
                <div class="form-group">
                    <select class="form-control" name="orderStatus">
                        <option value="">주문상태</option>
                        <option value="ORDER"
                                <c:if test="${orderSearch.orderStatus eq 'ORDER'}">selected</c:if> >주문
                        </option>
                        <option value="CANCEL"
                                <c:if test="${orderSearch.orderStatus eq 'CANCEL'}">selected</c:if> >취소
                        </option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">검색</button>
            </form>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>글쓴이</th>
                <th>제목</th>
                <th>내용</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${boardList}" var="list">
                <tr>
                    <td></td>
                    <td>${list.username}</td>
                    <td>${list.title}</td>
                    <td>${list.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div> <!-- /container -->

</body>
</html>
