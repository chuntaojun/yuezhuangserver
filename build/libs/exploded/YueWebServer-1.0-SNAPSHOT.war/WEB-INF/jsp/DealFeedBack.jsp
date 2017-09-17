<%--
  Created by IntelliJ IDEA.
  User: chuntaojun
  Date: 17-9-16
  Time: 下午11:22
  To change this template use File | Settings | File Templates.
--%>
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
    <style type="text/css">@import url("<c:url value="/resources/css/bootstrap-dialog.css" />");</style>

    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->

</head>

<f>
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
        <li><a href="/yue/report/<%=account  %>"><span class="glyphicon glyphicon-stats"></span> ${function_2}</a></li>
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

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">反馈处理</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="glyphicon glyphicon-envelope"></span> 商家反馈管理</div>
                <div class="panel-body">
                    <div class="panel-heading">商家反馈</div>
                    <div id="feed-mct" class="btn-group">
                        <button id="btn_delete" type="button" class="btn btn-default" onclick="deleInfo($('#feed-mct-table'),'/delete/admin/feedback/merchant');">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                        </button>
                    </div>
                    <table id="feed-mct-table"></table>
                </div>
            </div>
        </div>
    </div>
    <!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="glyphicon glyphicon-envelope"></span> 用户反馈管理</div>
                <div class="panel-body">
                    <div class="panel-heading">用户反馈</div>
                    <div id="feed-usr" class="btn-group">
                        <button id="btn_delete" type="button" class="btn btn-default" onclick="deleInfo($('#feed-usr-table'),'/delete/admin/feedback/user');">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                        </button>
                    </div>
                    <table id="feed-usr-table"></table>
                </div>
            </div>
        </div>
    </div>
    <!--/.row-->

    <%--弹出修改菜单--%>
    <form method="post" action="" class="form-horizontal" role="form" id="form_data" onsubmit="return false" style="margin: 20px;">
        <div class="modal fade" id="issueModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Issue信息</h4>
                    </div>
                    <div class="modal-body">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">反馈者</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="mctname" value="" id="account">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Email</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" name="mctemail" value="" id="mctemail">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Issue名称</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="quesname" value="" id="quesname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">反馈</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" name="solve" value="" id="solve" rows="7" style="resize: none"></textarea>
                                </div>
                            </div>
                        <input type="hidden" name="url" id="url" value="">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button onclick="IssueSolve()" class="btn btn-primary">提交</button><span id="tip"> </span>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </form>

</div>

<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<script src="/resources/js/bootstrap-editable.js"></script>
<script src="/resources/js/bootstrap-table.js"></script>
<script src="/resources/js/bootstrap-table-editable.js"></script>
<script src="/resources/js/bootstrap-dialog.js"></script>
<script src="/resources/js/jquery-form.js"></script>
<script src="/resources/js/feedbacktable.js"></script>
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