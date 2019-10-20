<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>
    <jsp:include page="../Commons/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../Commons/nav.jsp"/>
    <jsp:include page="../Commons/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                人员管理
                <small>员工管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 人员管理</a></li>
                <li class="active">员工管理</li>
            </ol>
        </section>
    </div>
    <jsp:include page="../Commons/copyright.jsp"/>
</div>
<jsp:include page="../Commons/footer.jsp"/>
</body>
</html>
