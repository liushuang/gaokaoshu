<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liushuang.ls
  Date: 14-4-30
  Time: 下午2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学科列表</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link rel="stylesheet" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
<div class="header ">
    <div class="header-box">
        <div class="logo">
            <a href=""></a>
        </div>
        <div class="main-nav">
            <ul>
                <li ><a href="/">首页</a></li>
                <li class="home-select nav-select"><a href="/list">列表页</a></li>
                <li><a href="">联系我们</a></li>
            </ul>
        </div>
    </div>
</div>
<h2>学科列表</h2>
<div class="content">
    <ul class="nav nav-tabs">
        <c:forEach items="${type_list}" var="first_type" varStatus="idx">
            <li class="active"><a href="#"> ${first_type.typeEntity.name}</a></li>
        </c:forEach>
    </ul>
    <div class="project-list">
        <c:forEach items="${type_list}" var="type">
            <ul>
                <c:forEach items="${type.childList}" var="second_type">
                    <li>
                        <a>${second_type.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
    </div>
    <div class="contact-us">
        <h3>联系方式</h3>
        <p></p>
    </div>
</div>
<script type="text/javascript" src="/resources/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/list.js"></script>
</body>
</html>
