<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>認証</title>
</head>
<body>
<h1>認証</h1>
<p>${mes}</p>
<form action="login" method="post">
使用者名：<input type="text" name="name"><br>
暗号：<input type="text" name="pass"><br>
<input type="submit" value="🔑認証！">
</form>
</body>
</html>