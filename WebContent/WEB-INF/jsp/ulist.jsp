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
<h1>売上一覧！</h1>
<p>歓迎、${user.uname}様！</p>
<p>電子手紙：${user.mail }</p>
<a href="logout">🔓認証解除</a>
<h3><a href="uinsert">追加</a>  <a href="slist">全商品一覧！</a></h3>
<table>
<tr><th>売上ID</th><th>商品ID</th><th>個数</th><th>日付</th></tr>
<c:forEach var="uriage" items="${list}">
	<tr>
		<td>${uriage.uid}</td>
		<td>${uriage.sid}</td>
		<td>${uriage.kosu}</td>
		<td>${uriage.hi}</td>
		<td><a href="uinfo?uid=${uriage.uid}">詳細</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>