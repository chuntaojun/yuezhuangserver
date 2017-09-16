<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>悦妆</title>

    <style type="text/css">@import url("<c:url value="/resources/css/bootstrap.min.css" />");</style>
    <style type="text/css">@import url("<c:url value="/resources/css/datepicker3.css" />");</style>
    <style type="text/css">@import url("<c:url value="/resources/css/styles.css" />");</style>

    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">悦妆 web后台管理</div>
            <div class="panel-body">
                <label style="color: palevioletred">${SPRING_SECURITY_LAST_EXCEPTION.message}${errors}</label>
                <form action="/login" method="post" id="loginFrom" onsubmit="return false">
                    <div class="form-group">
                        <input id="username" class="form-control" placeholder="账号" name="username" type="text" value="${username}" />
                    </div>
                    <div class="form-group">
                        <input id="password" class="form-control" placeholder="密码" name="password" type="password" />
                    </div>
                    <div class="form-group">
                    <label>
                        <a href="/retrievePassword">忘记密码?</a>
                    </label>
                    </div>
                    <button onclick="check();" class="btn btn-primary">登录</button>
                    <a href="/registered" style="float: right" class="btn btn-default">注册</a>
                </form>
            </div>
        </div>
    </div>
    <!-- /.col-->
</div>
<!-- /.row -->


<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<script>

    function check() {
        var fromID = document.getElementById("loginFrom");
        if (document.getElementById("username").value != "" && document.getElementById("password").value != "")
            fromID.submit();
        else
            alert("您还未输入账户或密码");
    }

    ! function($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function() {
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function() {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function() {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>