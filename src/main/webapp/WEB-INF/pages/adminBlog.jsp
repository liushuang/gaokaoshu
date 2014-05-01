<%--
  Created by IntelliJ IDEA.
  User: LiuShuang
  Date: 14-4-19
  Time: 下午3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>UMEDITOR 完整demo</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/base.css">
    <link href="/resources/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/jQuery.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/umeditor/umeditor.js"></script>
    <script type="text/javascript" src="/resources/umeditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<input type="hidden" name="typeId" value="${typeId}" />
<input type="hidden" name="blogId" value="${blogId}" />
<input type="hidden" name="content" value="${blog.content}"/>
<!--style给定宽度可以影响编辑器的最终宽度-->
<div class="container">
    <div class="text-area">
        <div class="clearfix text-title">
            <label>重点学科：</label>
            <input type="text" class="form-control" id="input-title1">
            <button class="btn btn-lg btn-primary btn-block delete-editor">删除小节</button>
        </div>
        <script type="text/plain" id="myEditor1" style="width:1000px;height:240px;">请输入内容</script>
    </div>
</div>
<div class="detail-btn">
    <button class="btn btn-lg btn-success btn-block" id="add-editor">增加小节</button>
    <button class="btn btn-lg btn-success btn-block" id="save-editor">保存</button>
</div>
<div class="will-delete">
    <div class="will-delete-content">
        <p>确定删除吗，删除之后将无法恢复！</p>
        <button id="is-delete">确定</button>
        <button id="no-delete">取消</button>
    </div>
</div>
<script type="text/javascript" src="/resources/js/backstage-detail.js"></script>
</body>
</html>
