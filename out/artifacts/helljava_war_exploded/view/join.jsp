<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <title>로그인</title>
    <jsp:include page="./fragments/head.jsp"/>
<body>

<c:if test="${empty sessionUserName}">
    <c:redirect url="/login.do"/>
</c:if>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/main.do">Home</a></li>
            <c:if test="${not empty sessionUserName}">
                <li><a href="/logout.do">로그아웃</a></li>
            </c:if>
        </ul>
        <h3 class="text-muted">회원가입완료</h3>
    </div>

    <div class="form-group">
        ${sessionUserName}님 회원가입을 축하합니다.
    </div>

</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
