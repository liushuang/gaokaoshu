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
    <form action="/admin/index/update">
        网站说明
        <input name="id" value="1" type="hidden" />
        <textarea name="text"></textarea>
        <button type="submit">提交</button>
    </form>

    <form action="/admin/index/update">
        报考概述
        <input name="id" value="2" type="hidden" />
        <textarea name="text"></textarea>
        <button type="submit">提交</button>
    </form>
</body>
</html>
