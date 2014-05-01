<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/index.css">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
</head>
<body>
    ${view_count}
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
                <c:forEach items="${second_hot_list}" var="second_type" begin="0" end="8">
                    <li class="row-first">
                        <a class="" href="#">
                            ${second_type.description}
                            <!--<img src="${second_type.imgUrl}" />-->
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="carousel slide" id="myCarousel">
            <ol class="carousel-indicators">
                <li class="" data-slide-to="0" data-target="#myCarousel"></li>
                <li data-slide-to="1" data-target="#myCarousel" class="active"></li>
                <li data-slide-to="2" data-target="#myCarousel"></li>
            </ol>
            <div class="carousel-inner">
                <c:forEach items="${first_hot_list}" var="first_type" begin="0" end="3">
                    <div class="item">
                        <img alt="" src="${first_type.imgUrl}">
                        <div class="carousel-caption">
                            <h3>First  label</h3>
                            <p>${first_type.description}</p>
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
            <p>${web_introduction.text}</p>
        </div>
        <div class="web-info ">
            <h4>报考概述</h4>
            <p>${baokaogaishu.text}</p>
        </div>
        <div class="web-info ">
            <h4>联系方式</h4>
            <p>网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明网站说明</p>
        </div>
    </div>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["mshare","qzone","tsina","weixin","renren","tqq","tieba","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    <script type="text/javascript" src="/resources/js/jQuery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>