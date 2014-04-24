<%--
  Created by IntelliJ IDEA.
  User: LiuShuang
  Date: 14-4-19
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach var="item"  items="${list}" >
        ${item.typeEntity.name}
    </c:forEach>

    <form action="/admin/addFirstType" method="post">
        <input type="text" name="name" />
        <button type="submit" >save</button>
    </form>
</body>
</html>
