<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
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
<h3>下記追加！真的確定？？</h3>
<table>
<tr><th>商品名</th><th>単価(円)</th></tr>
	<tr>
		<td><c:out value="${s.name}"/></td>
		<td>${s.tanka}</td>
	</tr>
</table>
<form action="insert" method="post">
<input type="submit" value="追加">
</form>
</body>
</html>