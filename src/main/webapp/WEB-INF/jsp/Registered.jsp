<%--
  Created by IntelliJ IDEA.
  User: chuntaojun
  Date: 17-7-26
  Time: 下午9:30
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="panel-heading">悦妆 商家注册</div>
            <div class="panel-body">
                <form action="/registere" method="post" id="disabledjump">
                    <div class="form-group">
                        <input id="username" class="form-control" placeholder="商家名称" name="username" type="text" value="" onkeyup="check_user_name()" />
                        <span id="user_error" style="color: #ff0000;"></span>
                    </div>
                    <div class="form-group">
                        <input id="useremail" class="form-control" placeholder="企业邮箱" name="email" type="email" value="" onkeyup="check_user_email()" />
                        <span id="email_error" style="color: #ff0000"></span>
                    </div>
                    <div class="form-group">
                        <input id="useraccount" class="form-control" placeholder="账户" name="mctaccount" type="text" value="" onkeyup="check_user_account()" />
                        <span id="account_error" style="color: #ff0000"></span>
                    </div>
                    <div class="form-group">
                        <input id="userpassword" class="form-control" placeholder="密码" name="password" type="password" value="" onkeyup="check_user_password()" />
                        <span id="password_error" style="color: #ff0000;"></span>
                    </div>
                    <div class="form-group">
                        <input id="userpassword-again" class="form-control" placeholder="再次输入密码" name="password-again" value="" type="password" onkeyup="check_user_password_again()">
                        <span id="password_error_again" style="color: #ff0000"></span>
                    </div>
                    <button type="submit" class="btn btn-primary">注册</button>
                </form>
            </div>
        </div>
    </div>
    <!-- /.col-->
</div>
<!-- /.row -->


<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/chart.min.js"></script>
<script src="/resources/js/chart-data.js"></script>
<script src="/resources/js/easypiechart.js"></script>
<script src="/resources/js/easypiechart-data.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<script src="/resources/js/yuezhuang.js"></script>
<script src="/resources/js/check_Info.js"></script>
<script>

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