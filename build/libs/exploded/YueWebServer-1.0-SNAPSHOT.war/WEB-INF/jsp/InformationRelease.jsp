<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="static com.yueserver.controller.LoginController.getPrincipal" %>
<%
    String account = getPrincipal().getUsername();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>悦妆</title>

    <style type="text/css">@import url("<c:url value="/resources/css/bootstrap.min.css" />");</style>
    <style type="text/css">@import url("<c:url value="/resources/css/datepicker3.css" />");</style>
    <style type="text/css">@import url("<c:url value="/resources/css/styles.css" />");</style>
    <style type="text/css">@import url("<c:url value="/resources/css/bootstrap-editable.css" />");</style>
    <style type="text/css">@import url("<c:url value="/resources/css/bootstrap-table.min.css" />");</style>

    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">悦妆 ${usertype}管理</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${username} <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> 登出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- /.container-fluid -->
</nav>

<sec:authorize access="hasRole('ADMIN')">
    <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
        <form role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
        </form>
        <ul class="nav menu">
            <li><a href="/admin/show"><span class="glyphicon glyphicon-dashboard"></span> 销售总览</a></li>
            <li><a href="/admin/businessmen"><span class="glyphicon glyphicon-th"></span> 商家管理</a></li>
            <li><a href="/yue/report/<%=account  %>"><span class="glyphicon glyphicon-stats"></span> 用户管理</a></li>
            <li><a href="/yue/query/<%=account  %>"><span class="glyphicon glyphicon-list-alt"></span> 商品数据</a></li>
            <li><a href="/yue/uploads/<%=account  %>"><span class="glyphicon glyphicon-pencil"></span> 商品信息录入 </a></li>
            <li class="parent ">
                <a href="#">
                    <span class="glyphicon glyphicon-list"></span> 更多功能 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
                </a>
                <ul class="children collapse" id="sub-item-1">
                    <sec:authorize access="hasRole('ADMIN')">
                        <li class="active">
                            <a class="" href="/admin/superhuman">
                                <span class="glyphicon glyphicon-share-alt"></span> 活动发布
                            </a>
                        </li>
                        <li>
                            <a class="" href="/admin/notic">
                                <span class="glyphicon glyphicon-share-alt"></span> 通告发布
                            </a>
                        </li>
                        <li>
                            <a class="" href="/deal/feedback">
                                <span class="glyphicon glyphicon-share-alt"></span> 反馈处理
                            </a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                        <li>
                            <a class="" href="/yue/issue/<%=account%>">
                                <span class="glyphicon glyphicon-share-alt"></span> 反馈问题
                            </a>
                        </li>
                    </sec:authorize>
                </ul>
            </li>
            <li role="presentation" class="divider"></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-user"></span> 登录页面</a></li>
        </ul>
    </div>
    <!--/.sidebar-->

    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
        <div class="row">
            <ol class="breadcrumb">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="active">通告发布</li>
            </ol>
        </div>
        <!--/.row-->

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">今日抢试</h1>
                <form id="todayTry" action="/gettodaytry" method="post" onsubmit="return todaytrySubmit();">
                    <fieldset>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                </div>
                            </div>
                        </div>
                    </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <!--/.row-->

        <!--/.row-->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">通知</h1>
                <form id="notice" action="/getnotice" method="post" onsubmit="return false">
                    <fieldset>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>通知标题</label>
                                            <input name="ncttitle" type="text" class="form-control" placeholder="通知标题">
                                        </div>
                                        <div class="form-group">
                                            <label>通知内容</label>
                                            <div class="form-group has-feedback">
                                                <textarea name="ntcmain" class="form-control" rows="5" style="resize: none" placeholder="通知内容"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-default" onclick="noticeSubmit()">发布</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <!--/.row-->
    </div>
</sec:authorize>
<!--/.main-->


<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/chart.min.js"></script>
<script src="/resources/js/chart-data.js"></script>
<script src="/resources/js/easypiechart.js"></script>
<script src="/resources/js/easypiechart-data.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<script src="/resources/js/bootstrap-table.js"></script>
<script src="/resources/js/bootstrap-table-editable.js"></script>
<script src="/resources/js/jquery-form.js"></script>
<script src="/resources/js/yuezhuang.js"></script>
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