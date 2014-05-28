<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/index.css">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
</head>
<body>
    <div class="header ">
        <div class="header-box">
            <div class="logo">
                <a href=""></a>
            </div>
            <div class="main-nav">
                <ul>
                    <li class="home-select nav-select"><a href="/">首页</a></li>
                    <li><a href="/list">列表页</a></li>
                    <li><a href="">联系我们</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="row-fluid">
            <ul>
                <li class="row-first">
                    <a class="" href="javascript:void(0)">
                        热门学科
                    </a>
                </li>
                <c:forEach items="${first_hot_list}" var="type" begin="0" end="8">
                    <li>
                        <a class="" href="${type.link}" target="_blank">
                            ${type.title}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="carousel slide" id="myCarousel" data-ride="carousel">
            <ol class="carousel-indicators">
                <c:forEach items="${second_hot_list}" var="type" begin="0" end="3" varStatus="status">
                    <li data-slide-to="${status.index}" data-target="#myCarousel"></li>
                </c:forEach>
            </ol>
            <div class="carousel-inner">
                <c:forEach items="${second_hot_list}" var="type" begin="0" end="3">
                    <div class="item">
                        <img alt="" src="${type.imgUrl}">
                        <div class="carousel-caption">
                            <h3>${type.title}</h3>
                            <p>${type.description}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <a data-slide="prev" href="#myCarousel" class="left carousel-control">‹</a>
            <a data-slide="next" href="#myCarousel" class="right carousel-control">›</a>
        </div>
    </div>
    <div class="content">
        <div class="section-title">
            <span>我们在做什么</span>
        </div>
        <div class="web-info ">
            <h4>网站说明</h4>
            <p><a href="/type/10">${web_introduction.text}</a></p>
        </div>
        <div class="web-info ">
            <h4>报考概述</h4>
            <p><a href="/type/11">${baokaogaishu.text}</a></p>
        </div>
        <div class="web-info ">
            <h4>联系方式</h4>
            <p>网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明</p>
        </div>
    </div>
    <div>${view_count}</div>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["mshare","qzone","tsina","weixin","renren","tqq","tieba","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    <script type="text/javascript" src="/resources/js/jQuery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>