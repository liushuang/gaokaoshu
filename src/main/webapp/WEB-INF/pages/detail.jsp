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
    <title>${type.name}</title>
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
            <a href=""></a>
        </div>
        <div class="main-nav">
            <ul>
                <li><a href="/">首页</a></li>
                <li><a href="/list">列表页</a></li>
                <li class="home-select nav-select"><a href="">学科文章</a></li>
                <li><a href="">联系我们</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <ul class="nav nav-tabs">
        <li><a href="#"></a></li>
    </ul>
    <div class="single-panel-inner">
        <div class="single-panel-header">
            <h3></h3>
        </div>
        <div class="single-panel-body">
        </div>
    </div>
    <div class="contact-us">
        <h3>联系方式</h3>
        <p></p>
    </div>
</div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["mshare","qzone","tsina","weixin","renren","tqq","tieba","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<script type="text/javascript" src="/resources/js/jQuery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/detail.js"></script>
</body>
</html>
