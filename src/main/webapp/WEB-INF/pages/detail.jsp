<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: liushuang.ls
  Date: 14-4-30
  Time: 下午3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报考书_${type.name}</title>
    <meta content="报考、高考报考、报考说明、报考经验、报考概述、专业、专业介绍、学科介绍、选专业、大学专业" name="keywords">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link rel="stylesheet" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/list.css">
    <link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>
<input type="hidden" name="typeId" id="blog-typeid" value="${blog.typeId}" />
<input type="hidden" name="blogId" id="blog-blogid" value="${blog.id}" />
<div class="header ">
    <div class="header-box">
        <div class="logo">
            <a href=""><img src="/resources/images/logobks.png"></a>
        </div>
        <div class="main-nav">
            <ul>
                <li><a href="/">首页</a></li>
                <li><a href="/list">学科列表</a></li>
                <li class="home-select nav-select">
                    <a href="javascript:void(0)">
                    <c:choose>
                        <c:when test="${blog.typeId  == 10}">
                            网站说明
                        </c:when>
                        <c:when test="${blog.typeId == 11}">
                            报考概述
                        </c:when>
                        <c:when test="${blog.typeId == 12}">
                            关于我们
                        </c:when>
                        <c:otherwise>
                            学科文章
                        </c:otherwise>
                    </c:choose>
                    </a>
                </li>
                <c:choose>
                    <c:when test="${blog.typeId == 12}">
                    </c:when>
                    <c:otherwise>
                    <li>
                        <a href="/type/12">关于我们</a>
                    </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <div class="nav">
        <ul class="nav-tabs">
        </ul>
        <c:if test="${fn:length(fileList) > 0}">
            <a data-local="blog-download" href="javascript:void(0)" id="down-link">下载附件</a>
        </c:if>
    </div>
    <div class="single-panel-inner">
        <div class="single-panel-header">
            <h3></h3>
            <b>作者：</b><span></span>
            <b>发表时间：</b><span>${create_time}</span>
            <b>访问次数：</b><span>${viewCount}</span>
        </div>
        <div class="single-panel-body">
        </div>
        <c:if test="${fn:length(fileList) > 0}">
            <div id="blog-download" class="blog-download">
                <h4>附件下载：</h4>
                <ul>
                    <c:forEach items="${fileList}" var="file">
                        <li>
                            <a href="/download?id=${file.id}">${file.originalName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <div class="count-btn">
          <a href="javascript:void(0)" id="count-up"><span>${blog.goodCount}</span>人顶</a>
          <a href="javascript:void(0)" id="count-normal"><span>${blog.middleCount}</span>人觉得无聊</a>
          <a href="javascript:void(0)" id="count-down"><span>${blog.badCount}</span>人踩</a>
        </div>
    </div>
    <div class="contact-us">
        <h3>联系方式</h3>
        <img src="/resources/images/contact.jpg" />
        <p>邮箱：baokaoshu@163.com<br>微信：公共主页-志愿君<br>微博：<a target="_blank" href="http://weibo.com/u/3224913505" style="padding: 0px;">@学长学姐说专业</a><br>QQ群：133190918<br></p>
    </div>
</div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["mshare","qzone","tsina","weixin","renren","tqq","tieba","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<script type="text/javascript" src="/resources/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/detail.js"></script>
</body>
</html>
