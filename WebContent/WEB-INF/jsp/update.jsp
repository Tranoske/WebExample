<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更</title>
</head>
<body>
<h3>入力変更内容↓↓↓</h3>
<form action="update" method="post">
商品ID：<input type = "text" name="sid" value="${s.sid}" readonly><br>
商品名？：<input type = "text" name="name" value="${s.name}"><br>
単価？：<input type = "text" name="price" value="${s.tanka}"><br>
<input type = "submit" value = "更新！">
</form>
</body>
</html>