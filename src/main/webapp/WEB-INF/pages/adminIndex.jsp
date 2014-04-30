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
    <title></title>
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
                <div>
                    <label>重点学科：</label>
                    <input class="form-control" type="text"/>
                </div>
                <ul class="course-img">
                    <li>
                        <label>重点学科图片和文字:</label>
                        <input class="form-control course-imgurl" type="text" placeholder="图片链接"/>
                        <input class="form-control course-title" type="text" placeholder="标题"/>
                        <input class="form-control course-text" type="text" placeholder="文案"/>
                    </li>
                </ul>
                <button class="btn btn-lg btn-primary btn-block img-add" type="submit">增加图片</button>
                <button class="btn btn-lg btn-primary btn-block img-save" type="submit">保存</button>
            </div>
        </div>
    </div>
</div>
<div class="add-btn clearfix" style="width:300px;">
    <button class="btn btn-lg btn-success btn-block" type="submit" id="add-course">增加学科分类</button>
    <button class="btn btn-lg btn-success btn-block" type="submit" id="save-course">保存</button>
</div>
<div>
    增加一级热门学科
    <form action="/admin/index/insertHotType" method="post" enctype="multipart/form-data">
        <input type="hidden" name="level" value="1" />
        学科id：<input type="text" name="typeId" placeholder=""/>
        描述：<input type="text" name="desc" />
        <input type="file" name="img"/>

        <button type="submit" >保存</button>
    </form>

    增加二级热门学科
    <form action="/admin/index/insertHotType" method="post" enctype="multipart/form-data">
        <input type="hidden" name="level" value="2" />
        学科id：<input type="text" name="typeId" placeholder=""/>
        描述：<input type="text" name="desc" />
        <input type="file" name="img"/>

        <button type="submit" >保存</button>
    </form>
</div>
</body>
</html>
