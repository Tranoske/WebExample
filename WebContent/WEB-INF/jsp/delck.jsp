<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
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
<h3>下記削除！真的確定？？</h3>
<table>
<tr><th>商品ID</th><th>商品名</th><th>単価(円)</th></tr>
	<tr>
		<td>${s.sid}</td>
		<td>${s.name}</td>
		<td>${s.tanka}</td>
	</tr>
</table>
<form action="del" method="post">
<input type = "hidden" name="sid" value="${s.sid}">
<input type="submit" value="真的削除！">
</form>
</body>
</html>