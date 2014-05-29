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
<!--style给定宽度可以影响编辑器的最终宽度-->
<div class="container blog-content">
    <div class="clearfix text-title">
        <label>标题：</label>
        <input type="text" id="blog-title" class="form-control">
        <label>作者：</label>
        <input type="text" id="blog-author" class="form-control">
        <label>时间：</label>
        <input type="text" id="blog-time" class="form-control">
    </div>
</div>
<div class="detail-btn">
    <button class="btn btn-lg btn-success btn-block btn-blog" id="add-editor">增加小节</button>
    <button class="btn btn-lg btn-success btn-block btn-blog" id="save-editor">保存</button>
    <input type="hidden" name="blogId" id="blog-blogid" value="${blogId}" />
    <form name="web-info" action="/admin/addBlog" method="post">
        <input name="content" id="blog-content" type="hidden"/>   
        <input type="hidden" name="typeId" id="blog-typeid" value="${typeId}" />
        <button class="btn btn-lg btn-success btn-block btn-blog" id="push-editor">提交</button>
    </form>
</div>
<div class="will-delete">
    <div class="will-delete-content">
        <p>确定删除吗，删除之后将无法恢复！</p>
        <button id="is-delete">确定</button>
        <button id="no-delete">取消</button>
    </div>
</div>
<div>
    <ul>
        <c:forEach items="${fileList}" var="file">
            <li>
                ${file.originalName}
                <a href="/admin/deleteFile?id=${file.id}">删除</a>
            </li>
        </c:forEach>
    </ul>
</div>
<script type="text/javascript" src="/resources/js/backstage-detail.js"></script>
<form action="/admin/upload" method="post" enctype="multipart/form-data">
    <input type="hidden" name="typeId" value="${typeId}">
    <input type="hidden" name="blogId" value="${blogId}">
    <input type="file" name="file">
    <button type="submit">Upload</button>
</form>
</body>
</html>
