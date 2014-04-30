<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>fileupload</title>
</head>
<body>
<div id="fileuploadContent">
    <h2>File Upload</h2>

    <form id="fileuploadForm" action="/admin/upload" method="POST" enctype="multipart/form-data">
        <div class="header">
            <h2>Form</h2>
            <c:if test="${not empty message}">
                <div id="message" class="success">${message}</div>
            </c:if>
        </div>
        <label for="file">File</label>
        <input id="file" type="file" name="file"/>
        <input type="hidden" name="blogId" value="1" />
        <p>
            <button type="submit">Upload</button>
        </p>
    </form>
</div>
</body>
</html>