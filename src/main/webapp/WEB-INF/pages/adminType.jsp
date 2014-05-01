<%--
  Created by IntelliJ IDEA.
  User: LiuShuang
  Date: 14-4-19
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理学科</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/base.css">
</head>
<body>
<div class="nav">
    <a href="/admin/adminIndex">首页</a>
    <a href="/admin/adminType">列表页</a>
</div>
<div class="contanier clearfix">
<c:forEach var="item" items="${list}">
    <div class="backstage">
        <div class="department">
            <a href="javascript:void(0)" data-id="${item.typeEntity.id}">${item.typeEntity.name}</a>
            <i>×</i>

            <div class="department-input">
                <input class="div-control input-small input-name" type="text"/>
                <button class="btn btn-lg btn-success btn-block btn-small save-name" type="submit">保存</button>
            </div>
        </div>
        <ul class="course clearfix">
            <c:forEach items="${item.childList}" var="child_type">
                <li>
                    <a href="/type/${child_type.id}" target="_blank" data-id="${child_type.id}">${child_type.name}</a>
                    <i>×</i>
                </li>
            </c:forEach>
        </ul>
        <div class="add-btn clearfix">
            <button class="btn btn-lg btn-primary btn-block add-course" type="submit">增加学科</button>
        </div>
    </div>
</c:forEach>
</div>
<div class="add-btn clearfix" style="width:300px;">
    <button class="btn btn-lg btn-success btn-block" type="submit" id="add-department">增加学科分类</button>
    <button class="btn btn-lg btn-success btn-block" type="submit" id="save-department">保存</button>
</div>
<div class="will-delete">
    <div class="will-delete-content">
        <p>确定删除吗，删除之后将无法恢复！</p>
        <button id="is-delete">确定</button>
        <button id="no-delete">取消</button>
    </div>
</div>
<script type="text/javascript" src="/resources/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/backstage-list.js"></script>
</body>
</html>
