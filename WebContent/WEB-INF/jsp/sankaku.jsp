<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>三角形の面積は...</title>
</head>
<body>
<h1>気になる三角形の面積.....</h1>
<p>底辺(${sankaku.num1 })、高さ(${sankaku.num2 })の面積</p>
<form action="menseki" method="get">
<input type="submit" value="本当に見る">
</form>
</body>
</html>