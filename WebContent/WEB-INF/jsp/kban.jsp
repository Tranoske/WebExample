<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<style>
td,th{
	padding:0.2em 0.5em;
}
table{
	border-collapse: collapse;
}
</style>
<body>
<h1>テストモード。<br>
試験中でございます。
</h1>
<form action="kban" method="post">
name？：<input type = "text" name="name" value="ＫＩＳの名無しさん。"><br>
本文？：<textarea name="bun"></textarea><br>
<input type = "submit" value = "書き込む！">
</form>
<table>
<c:forEach var="k" items="${klist}">
	<tr>
		<th>${k.kid}.</th>
		<th>書込：${k.hi}</th>
		<th>${k.name}</th>
		<td><a href="kdel?kid=${k.kid}">削除</a></td>
	</tr>
<td>${k.bun}</td>
</c:forEach>
</table>
</body>
</html>