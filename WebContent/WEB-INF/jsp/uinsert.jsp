<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上登録</title>
</head>
<body>
<h1>売上登録！</h1>
<form action="uinsert" method="post">
商品ID？：<select name="sid">
<c:forEach var="shohin" items="${list}">
<option value="${shohin.sid}">${shohin.sid}: ${shohin.name}</option>
</c:forEach>
</select><br>
個数？：<input type = "text" name="kosu"><br>
<input type = "submit" value = "追加！">
</form>
</body>
</html>