<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<title>로그인</title>
<jsp:include page="./fragments/head.jsp"/>
<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/main.do">Home</a></li>
        </ul>
        <h3 class="text-muted">로그인</h3>
    </div>

    <form role="form" action="/login.do" method="post">
        <div class="form-group">
            <label for="userid">ID</label>
            <input type="text" name="userid" class="form-control" id="userid" placeholder="ID를 입력하세요" value="${c_id}" required>
        </div>
        <div class="form-group">
            <label for="userpassword">비밀번호</label>
            <input type="password" name="userpassword" class="form-control" id="userpassword" placeholder="비밀번호를 입력하세요" required>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="isSaveCheck" id="isSaveCheck" ${isSaveCheck == "Y" ? "checked" : ""}> 아이디저장
            </label>
        </div>
        <a href="/register.do"><p>회원가입</p></a>
        <button type="submit" class="btn btn-default">로그인</button>
    </form>
</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
