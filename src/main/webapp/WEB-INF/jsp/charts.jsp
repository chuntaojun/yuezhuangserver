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

    <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
        <form role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
        </form>
        <ul class="nav menu">
            <sec:authorize access="hasRole('ADMIN')">
            <li><a href="/admin/show"><span class="glyphicon glyphicon-dashboard"></span> 销售总览</a></li>
            <li><a href="/admin/businessmen"><span class="glyphicon glyphicon-th"></span> 商家管理</a></li>
            </sec:authorize>
            <li class="active"><a href="/yue/report/<%=account  %>"><span class="glyphicon glyphicon-stats"></span> ${function_2}</a></li>
            <li><a href="/yue/query/<%=account  %>"><span class="glyphicon glyphicon-list-alt"></span> 商品数据</a></li>
            <li><a href="/yue/uploads/<%=account  %>"><span class="glyphicon glyphicon-pencil"></span> 商品信息录入 </a></li>
            <sec:authorize access="hasRole('ADMIN')">
            <li class="parent ">
                <a href="#">
                    <span class="glyphicon glyphicon-list"></span> 消息发布 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
                </a>
                <ul class="children collapse" id="sub-item-1">
                    <li>
                        <a class="" href="/admin/superhuman">
                            <span class="glyphicon glyphicon-share-alt"></span> 达人
                        </a>
                    </li>
                    <li>
                        <a class="" href="/admin/hot">
                            <span class="glyphicon glyphicon-share-alt"></span> 热门
                        </a>
                    </li>
                    <li>
                        <a class="" href="/admin/notic">
                            <span class="glyphicon glyphicon-share-alt"></span> 通知
                        </a>
                    </li>
                </ul>
            </li>
            </sec:authorize>
            <li role="presentation" class="divider"></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-user"></span> 登录页面</a></li>
        </ul>
    </div>
    <!--/.sidebar-->

    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
        <div class="row">
            <ol class="breadcrumb">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="active">数据报表</li>
            </ol>
        </div>
        <!--/.row-->

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">数据报表</h1>

            </div>
        </div>
        <!--/.row-->
        <sec:authorize access="hasRole('USER')">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Line Chart</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.row-->

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Bar Chart</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="main-chart" id="bar-chart" height="200" width="600"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.row-->

        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Pie Chart</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="chart" id="pie-chart"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Doughnut Chart</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="chart" id="doughnut-chart"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.row-->

        <div class="row">
            <div class="col-xs-6 col-md-3">
                <div class="panel panel-default">
                    <div class="panel-body easypiechart-panel">
                        <h4>Label:</h4>
                        <div class="easypiechart" id="easypiechart-blue" data-percent="92"><span class="percent">92%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3">
                <div class="panel panel-default">
                    <div class="panel-body easypiechart-panel">
                        <h4>Label:</h4>
                        <div class="easypiechart" id="easypiechart-orange" data-percent="65"><span class="percent">65%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3">
                <div class="panel panel-default">
                    <div class="panel-body easypiechart-panel">
                        <h4>Label:</h4>
                        <div class="easypiechart" id="easypiechart-teal" data-percent="56"><span class="percent">56%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3">
                <div class="panel panel-default">
                    <div class="panel-body easypiechart-panel">
                        <h4>Label:</h4>
                        <div class="easypiechart" id="easypiechart-red" data-percent="27"><span class="percent">27%</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.row-->
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading"><span class="glyphicon glyphicon-envelope"></span> 修改个人信息</div>
                        <div class="panel-body">
                            <div class="panel-heading">用户管理</div>
                            <div id="toolbar_user" class="btn-group">
                                <button id="btn_delete" type="button" class="btn btn-default" onclick="deleInfo($('#userTable'), '/admindeleteUser')">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                                </button>
                            </div>
                            <table id="userTable"></table>
                            <div class="panel-heading">发帖管理</div>
                            <div id="toolbar_post" class="btn-group">
                                <button id="btn_delete" type="button" class="btn btn-default" onclick="deleInfo($('#postTable'), '/admindeletePost')">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                                </button>
                            </div>
                            <table id="postTable"></table>
                        </div>
                    </div>
                </div>
            </div>
        </sec:authorize>

    </div>
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
    <script src="/resources/js/myBootstraptable.js"></script>
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