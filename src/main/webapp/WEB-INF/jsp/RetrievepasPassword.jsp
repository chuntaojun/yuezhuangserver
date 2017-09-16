<%--
  Created by IntelliJ IDEA.
  User: chuntaojun
  Date: 17-8-16
  Time: 上午7:36
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
            <div class="panel-heading">悦妆 web 找回密码</div>
            <div class="panel-body">
                <form action="/forgotPassword" method="post" id="getPas" onsubmit="return false">
                    <div class="form-group">
                        <input id="username" class="form-control" placeholder="账号" name="username" type="text" required />
                    </div>
                    <div class="form-group">
                        <input id="email" class="form-control" placeholder="邮箱" name="email" type="email" required />
                    </div>
                    <div class="form-group">
                        <input id="password" class="form-control" placeholder="新密码" name="password" type="password" required />
                    </div>
                    <div class="form-group">
                        <input id="authcode" class="form-control" placeholder="验证码" name="authcode" type="text" required />
                    </div>
                    <div>
                        <span style="color: red"> ${forgoterrors} </span>
                    </div>
                    <input id="emailcode" type="button" class="btn btn-danger" value="获取验证码" />
                    <button onclick="isSubmit();" class="btn btn-primary">提交</button>
                </form>
                <div id="test"></div>
            </div>
        </div>
    </div>
    <!-- /.col-->
</div>
<!-- /.row -->

<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.cookie.js"></script>
<script>

    var getpas = document.getElementById("getPas");

    function isSubmit() {
        if ($("#authcode").val() != null || $("#authcode").val() != "") {
            getpas.submit();
        }
        else {
            alert("验证码还未填写");
        }
    }

    //按钮获取验证码60秒限制
    $(function(){

        /**
         * 防刷新：检测是否存在cookie
         */
        if($.cookie("captcha")){
            var count = $.cookie("captcha");
            var btn = $('#emailcode');
            btn.val(count+'秒后可重新获取').attr('disabled',true).css('cursor','not-allowed');
            var resend = setInterval(function(){
                count--;
                if (count > 0){
                    btn.val(count+'秒后可重新获取').attr('disabled',true).css('cursor','not-allowed');
                    $.cookie("captcha", count, {path: '/', expires: (1/86400)*count});
                }else {
                    clearInterval(resend);
                    btn.val("获取验证码").removeClass('disabled').removeAttr('disabled style');
                }
            }, 1000);
        }

        /**
         * 点击改变按钮状态，已经简略掉ajax发送短信验证的代码
         */
        $('#emailcode').click(function() {
            if ($("#email").val() != "") {
                var btn = $(this);
                $.ajax({
                    type: 'get',
                    url: '/getemailauthcode?email=' + $("#email").val(),
                });
                var count = 60;
                var resend = setInterval(function () {
                    count--;
                    if (count > 0) {
                        btn.val(count + "秒后可重新获取");
                        $.cookie("captcha", count, {path: '/', expires: (1 / 86400) * count});
                    } else {
                        clearInterval(resend);
                        btn.val("获取验证码").removeAttr('disabled style');
                    }
                }, 1000);
                btn.attr('disabled', true).css('cursor', 'not-allowed');
            }
            else
                alert("请先填好邮箱信息");
        });
    });


</script>

</body>
</html>
