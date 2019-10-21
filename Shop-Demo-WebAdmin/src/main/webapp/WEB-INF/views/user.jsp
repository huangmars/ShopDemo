<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
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
                <small>用户管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 人员管理</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <!-- /.box-header -->
                        <div class="box-header">
                            <div class="col-md-6">
                                <h3 class="box-title">用户列表</h3>
                            </div>

                            <div class="box-group col-md-3">
                                <button type="button" class="btn btn-default btn-sm">新增用户</button>
                                <button type="button" class="btn btn-default btn-sm">批量删除</button>
                                <button type="button" class="btn btn-default btn-sm">导入</button>
                                <button type="button" class="btn btn-default btn-sm">导出</button>
                            </div>

                            <div class="box-tools col-md-3">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>ID</th>
                                    <th>姓名</th>
                                    <th>账号</th>
                                    <th>密码</th>
                                    <th>邮件</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="user">
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <td>${user.tId}</td>
                                    <td>${user.tUsername}</td>
                                    <td>${user.tAccount}</td>
                                    <td>${user.tPassword}</td>
                                    <td>${user.tEmail}</td>
                                    <td>
                                        <button type="button" class="btn btn-default btn-sm">查看</button>
                                        <button type="button" class="btn btn-info btn-sm">编辑</button>
                                        <button type="button" class="btn btn-danger btn-sm">删除</button>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>

                        <div class="box-footer">
                            <div class="col-sm-8">
                                <div class="dataTables_info" id="example2_info" role="status" aria-live="polite" style="margin-top: 25px">
                                    Showing ${pageInfo.pageNum} of ${pageInfo.pages} pages</div>
                            </div>
                            <div class="col-sm-4">
                                <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button previous" id="example2_previous"><a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>

                                        <c:forEach items="${pageInfo.navigatepageNums}" var="navigatepageNums">
                                            <li class="paginate_button ">
                                                <a class="${navigatepageNums==pageInfo.pageNum?"active":""}" href="${APP_PATH}/users?pageNum=${navigatepageNums}" aria-controls="example2" data-dt-idx="1" tabindex="0">${navigatepageNums}</a>
                                            </li>
                                        </c:forEach>

                                        <li class="paginate_button next disabled" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </section>
    </div>
    <jsp:include page="../Commons/copyright.jsp"/>
</div>
<jsp:include page="../Commons/footer.jsp"/>
</body>
</html>
