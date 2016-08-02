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
            <li class="active"><a href="/main.do">Home</a></li>
        </ul>
        <h3 class="text-muted">회원 가입</h3>
    </div>
    <form>
        <div class="form-group">
            <label for="userid">ID</label>
            <input type="text" name="userid" class="form-control" id="userid" placeholder="ID를 입력하세요">
        </div>
        <div class="form-group">
            <label for="username">이름</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="이름을 입력하세요">
        </div>
        <div class="form-group">
            <label for="userpassword">비밀번호</label>
            <input type="password" name="userpassword" class="form-control" id="userpassword" placeholder="비밀번호를 입력하세요">
        </div>
        <div class="form-group">
            <label for="useremail">이메일</label>
            <input type="email" name="useremail" class="form-control" id="useremail" placeholder="이메일을 입력하세요">
        </div>
        <button type="button" id="submit" value="submit" class="btn btn-default">회원가입</button>
    </form>
</div> <!-- /container -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>

<script>

    $('#submit').click(function () {

        var name = $("#username").val();
        var password = $("#userpassword").val();
        var id = $("#userid").val();
        var email = $("#useremail").val();

        $.ajax({
            url: '/join.do',
            type: 'post',
            data: {
                name: name,
                password: password,
                id: id,
                email: email
            },
            success: function (data) {
                alert("회원가입을 축하합니다.");
                location.href = "main.do";
            },
            error: function (xhr, status, error) {
                alert(error);
            }
        });
    })

</script>