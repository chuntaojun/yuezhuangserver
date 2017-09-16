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
    <style type="text/css">@import url("<c:url value="/resources/css/dropzone.css" />");</style>

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
            <a class="navbar-brand" href="#">悦妆 ${usertype}后台管理</a>
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
        <li class="active"><a href="/yue/uploads/<%=account  %>"><span class="glyphicon glyphicon-pencil"></span> 商品信息录入 </a></li>
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
            <li class="active"> ${function} </li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"> ${function} </h1>
        </div>
    </div>
    <!--/.row-->
    <sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
    <div class="row">
        <div class="col-lg-12">
            <label style="color: palevioletred">品牌信息</label>
            <div class="panel panel-default">
                <form id="brdInfo" action="/uploadBrdInfo" method="post" onsubmit="return false" enctype="multipart/form-data">
                <div class="panel-body">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>品牌名称</label>
                            <input name="brdname" class="form-control" placeholder="品牌名称">
                        </div>
                        <div class="form-group">
                            <label>品牌介绍</label>
                            <input name="brdintro" class="form-control" placeholder="品牌介绍">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>品牌logo</label>
                            <input name="logo" type="file" value="上传品牌logo">
                        </div>
                        <button class="btn btn-primary" onclick="brdSubmit()">上传</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
    </sec:authorize>
    <sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
        <form id="disabledjump" name="form1" method="post" action="/uploadprdinfo" onsubmit="return disabledjump();">
            <fieldset>
                <div class="row">
                    <div class="col-lg-12">
                        <label style="color: palevioletred">商品文字信息</label>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>商品品牌</label>
                                        <input name="brdname" type="text" class="form-control" placeholder="品牌名称">
                                    </div>
                                    <div class="form-group">
                                        <label>商品名称</label>
                                        <input name="prdname" type="text" class="form-control" placeholder="商品名称">
                                    </div>
                                    <div class="form-group">
                                        <label>商品价格</label>
                                        <input id="prdprice" name="prdprice" type="text" class="form-control" placeholder="示例 120">
                                    </div>
                                        <div class="form-group">
                                        <label>商品一维码</label>
                                        <input id="prdcode" name="prdcode" type="text" class="form-control" placeholder="输入商品一维码">
                                    </div>
                                    <div class="form-group">
                                        <label>产品细则</label>
                                        <div class="form-group has-feedback">
                                            <textarea name="prdintro" class="form-control" rows="3" style="resize: none;" placeholder="商品简介"></textarea>
                                        </div>
                                        <div class="form-group has-success">
                                            <input id="prdcapacity" name="prdcapacity" type="text" class="form-control" placeholder="容量 （ml）">
                                        </div>
                                    </div>
                                    <input id="submittype" name="submittype" type="hidden" value="">
                                    <input type="button" class="btn btn-primary" onclick="SubmitType(true);" value="提交商品文字信息" />
                                    <input type="button" class="btn btn-primary" onclick="SubmitType(false);" value="更新商品文字信息" />
                                    <button type="reset" class="btn btn-default" >重置商品信息</button>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>产品分类</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="prdtypeno" id="optionsRadios1" value="1" checked>乳剂类
                                            </label>
                                        </div>
                                        <div class="radio">
                                        <label>
                                            <input type="radio" name="prdtypeno" id="optionsRadios2" value="2">粉 类
                                        </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="prdtypeno" id="optionsRadios3" value="3">美容类
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="prdtypeno" id="optionsRadios4" value="4">香水类
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                            <input type="radio" name="prdtypeno" id="optionsRadios5" value="5">香波类
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="prdtypeno" id="optionsRadios6" value="6">疗效类
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col-->
                </div>
            </fieldset>
        </form>
        <div class="row">
            <div class="col-lg-12">
                <label style="color: palevioletred">上传商品图片信息</label>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="form-group">
                            <label>商品品牌</label>
                            <input id="brd" name="brdname" type="text" class="form-control" placeholder="品牌名称">
                        </div>
                        <div class="form-group">
                            <label>商品名称</label>
                            <input id="prd" name="prdname" type="text" class="form-control" placeholder="商品名称">
                        </div>
                        <div id="dropzone" class="dropzone"></div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary" id="submit-all" disabled="disabled">上传商品图片</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label style="color: palevioletred">上传商品视频信息</label>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form id="vid_form" action="/uploadprdvideo" method="post" enctype="multipart/form-data" onsubmit="return vid_submit();">
                            <div class="form-group">
                                <label>商品品牌</label>
                                <input name="brdname" type="text" class="form-control" placeholder="品牌名称">
                            </div>
                            <div class="form-group">
                                <label>商品名称</label>
                                <input name="prdname" type="text" class="form-control" placeholder="商品名称">
                            </div>
                            <input id="prdvideo" name="prdvideo" type="file" value="点击上传视频文件">
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="上传商品视频" />
                            </div>
                        </form>
                        </div>
                </div>
            </div>
        </div>
    </div>
    </sec:authorize>
    <!-- /.row -->

</div>
<!--/.main-->
<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/dropzone.js"></script>
<script src="/resources/js/dateanddropzone.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/chart.min.js"></script>
<script src="/resources/js/chart-data.js"></script>
<script src="/resources/js/easypiechart.js"></script>
<script src="/resources/js/easypiechart-data.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<script src="/resources/js/jquery-form.js"></script>
<script src="/resources/js/yuezhuang.js"></script>
<script>
    function brdSubmit() {
        $("#brdInfo").ajaxSubmit(function (message) {
            if (message == false)
                alert("上传品牌信息失败")
        })
    }
</script>
</body>

</html>