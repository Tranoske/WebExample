<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除 | ${k.kid}</title>
</head>
<body>
<h1>削除確認</h1>
<h3>削除しますか？？</h3>
<table>
<tr><th>kid</th><th>hi</th><th>name</th><th>bun</th></tr>
	<tr>
	<td>${k.kid}</td>
	<td>${k.hi}</td>
	<td>${k.name}</td>
	<td>${k.bun}</td>
	</tr>
</table>
<form action="kdel" method="post">
<input type = "hidden" name="kid" value="${k.kid}">
<input type = "submit" value = "はい">
<a href="kban">いいえ</a>
</form>
</body>
</html>