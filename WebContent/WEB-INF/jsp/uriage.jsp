<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上一覧</title>
<style>
td,th{
	border:1px solid gray;
	padding:0.2em 0.5em;
}
table{
	border-collapse: collapse;
}
</style>
</head>
<body>
<h1>${s.name}の売上一覧！</h1>
<h3><a href="slist">戻</a></h3>
<table>
<tr><th>日付</th><th>売上ID</th><th>個数</th></tr>
<c:forEach var="uriage" items="${list}">
	<tr>
		<td>${uriage.hi}</td>
		<td>${uriage.uid}</td>
		<td>${uriage.kosu}</td>
	</tr>
</c:forEach>
</table>

<form method="post" action="uriage">
<input type = "hidden" name="sid" value="${s.sid}"><br>
個数？：<input type = "text" name="kosu">
<input type = "submit" value = "追加！">
</form>

</body>
</html>