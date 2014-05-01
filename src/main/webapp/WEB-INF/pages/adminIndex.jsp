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
        <a href="">列表页</a>
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
                <div class="course-main clearfix">
                    <label>重点学科：</label>
                    <input class="form-control course-id" type="text" placeholder="学科ID" /> 
                    <input class="form-control course-title" type="text" placeholder="学科名"/>            
                </div>
            </div>
            <button class="btn btn-lg btn-success btn-block" type="submit" id="add-course">增加学科分类</button>
            <button class="btn btn-lg btn-success btn-block" type="submit" id="save-course">保存</button>
        </div>
        <div class="clearfix backstage course-info">
            <h3>轮播图</h3>
            <ul class="course-img">
                <li>
                    <label>图片和文字:</label>
                    <i>×</i>
                    <form action="/admin/index/insertHotType" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="level" value="1" />
                        <input type="text" name="link" placeholder="链接" />
                        <input type="text" name="desc" placeholder="描述" />
                        <input type="file" name="img" />
                        <button type="submit" class="btn btn-lg btn-success btn-block">保存</button>
                    </form>
                </li>
            </ul>
            <button class="btn btn-lg btn-primary btn-block img-add" type="submit">增加图片</button>
        </div>
    </div>
    <div class="add-btn clearfix" style="width:300px;">
        <button class="btn btn-lg btn-success btn-block" type="submit" id="add-course">增加学科分类</button>
        <button class="btn btn-lg btn-success btn-block" type="submit" id="save-course">保存</button>
    </div>
    <div class="add-btn clearfix" style="width:300px;margin:0 auto">
        <button class="btn btn-lg btn-success btn-block" style="width:100%;" type="submit" id="save-course">保存</button>
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
