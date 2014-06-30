<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报考书_首页</title>
    <meta content="报考、高考报考、报考说明、报考经验、报考概述、专业、专业介绍、学科介绍、选专业、大学专业" name="keywords">
    <link rel="stylesheet" href="/resources/css/index.css">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
</head>
<body>
    <div class="header ">
        <div class="header-box">
            <div class="logo">
                <a href=""><img src="/resources/images/logo.png"></a>
            </div>
            <div class="main-nav">
                <ul>
                    <li class="home-select nav-select"><a href="/">首页</a></li>
                    <li><a href="/list">学科列表</a></li>
                    <li><a href="/type/12">关于我们</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="row-fluid">
            <ul>
                <li class="row-first">
                    <a href="javascript:void(0)">
                        学科分类
                    </a>
                </li>
                <c:forEach items="${first_hot_list}" var="type" begin="0" end="8">
                    <li>
                        <a href="${type.link}" target="_blank">
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
                        <a href="${type.link}" target="_blank"><img alt="" src="${type.imgUrl}"></a>
                        <div class="carousel-caption">                            
                            <h3><a href="${type.link}" target="_blank">${type.title}</a></h3>                           
                            <p><a href="${type.link}" target="_blank">${type.description}</a></p>
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
            <p>${web_introduction.text}<a target="_blank" href="/type/10" >更多>></a></p>
        </div>
        <div class="web-info ">
            <h4>报考综述</h4>
            <p>${baokaogaishu.text}<a target="_blank" href="/type/11">更多>></a></p>
        </div>
        <div class="web-info ">
            <h4>联系方式</h4>
            <p style="text-align:left;padding-left:40px;">邮箱：baokaoshu@163.com<br />微信：公共主页-志愿君<br />微博：<a href="http://weibo.com/u/3224913505" target="_blank" style="padding:0;">@学长学姐说专业</a><br />QQ群：133190918<br /><a href="/type/12" style="padding-left:0px;" target="_blank">更多>></a></p>
        </div>
        <span>访问人数：${view_count}</span><span style="margin-left: 20px"><a href="http://www.miitbeian.gov.cn/" target="_blank">京ICP备14021289号</a></span>
    </div>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["mshare","qzone","tsina","weixin","renren","tqq","tieba","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    <script type="text/javascript" src="/resources/js/jQuery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>