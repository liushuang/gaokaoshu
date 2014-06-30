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
    <title>报考书_学科列表</title>
    <meta content="报考、高考报考、报考说明、报考经验、报考概述、专业、专业介绍、学科介绍、选专业、大学专业" name="keywords">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link rel="stylesheet" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
<div class="header ">
    <div class="header-box">
        <div class="logo">
            <a href=""><img src="/resources/images/logobks.png"></a>
        </div>
        <div class="main-nav">
            <ul>
                <li><a href="/">首页</a></li>
                <li class="home-select nav-select"><a href="/list">学科列表</a></li>
                <li><a href="/type/12">关于我们</a></li>
            </ul>
        </div>
    </div>
</div>
<h2>学科列表</h2>

<div class="content">
    <ul class="nav nav-tabs">
        <c:forEach items="${type_list}" var="first_type" varStatus="idx">
            <li><a href="javascript:void(0)"> ${first_type.typeEntity.name}</a></li>
        </c:forEach>
    </ul>
    <c:forEach items="${type_list}" var="type">
        <div class="project-list">
            <ul>
                <c:forEach items="${type.childList}" var="second_type">
                    <li>
                        <a href="/type/${second_type.id}">${second_type.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
    <div class="contact-us">
        <h3>联系方式</h3>
        <img src="/resources/images/contact.jpg" />
        <p>邮箱：baokaoshu@163.com<br>微信：公共主页-志愿君<br>微博：<a target="_blank" href="http://weibo.com/u/3224913505" style="padding: 0px;">@学长学姐说专业</a><br>QQ群：133190918<br></p>
    </div>
</div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["mshare","qzone","tsina","weixin","renren","tqq","tieba","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<script type="text/javascript" src="/resources/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/list.js"></script>
</body>
</html>
