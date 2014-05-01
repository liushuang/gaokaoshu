<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LiuShuang
  Date: 14-4-13
  Time: 上午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理首页</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/base.css">
</head>
<body>
    <div class="nav">
        <a href="/admin/adminIndex">首页</a>
        <a href="/admin/adminType">列表页</a>
    </div>
    <div class="contanier clearfix">
        <div class="clearfix backstage">
            <h3>网站信息</h3>
            <ul>
                <li class="clearfix">
                    <form name="web-info" action="/admin/index/update" method="post">
                        <input name="id" value="1" type="hidden"/>
                        <label>网站说明：</label>
                        <textarea class="form-control text-web" name="text">${wangzhanshuoming}</textarea>
                        <button class="btn btn-lg btn-primary btn-block save-web" type="submit">保存</button>
                    </form>
                </li>
                <li class="clearfix">
                    <form name="exam-info" action="/admin/index/update" method="post">
                        <input name="id" value="2" type="hidden"/>
                        <label>报考概述：</label>
                        <textarea class="form-control text-exam" name="text">${baokaogaishu}</textarea>
                        <button class="btn btn-lg btn-primary btn-block save-exam" type="submit">保存</button>
                    </form>
                </li>
            </ul>
        </div>
        <div class="clearfix backstage course-info">
            <h3>学科信息</h3>
            <div class="course-content">
                <c:forEach items="${firstHotTypeList}" var="type" begin="0" end="8">
                    <div class="course-main clearfix">
                        <label>重点学科：</label>
                        <form action="/admin/index/updateHotType" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="id" value="${type.id}" />
                            <input type="file" name="img" style="display:none" />
                            <label>链接：</label><input name="link" class="form-control course-id" type="text" value="${type.link}" />
                            <label>学科名：</label><input name="title" class="form-control course-title" type="text" value="${type.title}"/>
                            <button class="btn btn-lg btn-success btn-block" type="submit">保存</button>
                        </form>
                    </div>
                </c:forEach>
                <div class="course-main clearfix">
                    <label>新增专业：</label>
                    <form action="/admin/index/insertHotType" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="level" value="1" />
                        <input type="file" name="img" style="display:none" />
                        <label>链接：</label><input name="link" class="form-control course-id" type="text" placeholder="学科ID" />
                        <label>学科名：</label><input name="title" class="form-control course-title" type="text" placeholder="学科名"/>
                        <button class="btn btn-lg btn-success btn-block" type="submit">保存</button>
                    </form>
                </div>
            </div>

        </div>
        <div class="clearfix backstage course-info">
            <h3>轮播图</h3>
            <ul class="course-img">
                <c:forEach items="${secondHotTypeList}" var="type" >
                    <li>
                        <label>图片和文字:</label>
                        <i>×</i>
                        <form action="/admin/index/updateHotType" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="level" value="2" />
                            <input type="hidden" name="id" value="${type.id}" />
                            链接：<input type="text" name="link" value="${type.link}" />
                            标题：<input type="text" name="title" value=" ${type.title}" />
                            描述：<input type="text" name="desc" value="${type.description}" />
                            <input type="file" name="img" />
                            <button type="submit" class="btn btn-lg btn-success btn-block">保存</button>
                        </form>
                    </li>
                </c:forEach>
                <li>
                    <label>新增首页轮播图:</label>
                    <i>×</i>
                    <form action="/admin/index/insertHotType" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="level" value="2" />
                        <input type="text" name="link" placeholder="链接" />
                        <input type="text" name="title" placeholder="标题" />
                        <input type="text" name="desc" placeholder="描述" />
                        <input type="file" name="img" />
                        <button type="submit" class="btn btn-lg btn-success btn-block">保存</button>
                    </form>
                </li>
            </ul>
        </div>
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
    <script type="text/javascript" src="/resources/js/backstage-index.js"></script>
</body>
</html>
