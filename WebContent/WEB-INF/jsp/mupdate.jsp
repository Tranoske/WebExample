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
<form action="mupdate" method="post">
<input type = "hidden" name="action" value="update" readonly>
<input type = "hidden" name="mid" value="${m.mid}" readonly><br>
氏名？：<input type = "text" name="name" value="${m.name}"><br>
住所？：<input type = "text" name="adr" value="${m.adr}"><br>
<input type = "submit" value = "更新！">
</form>
<form action="mdel" method="post">
<input type = "hidden" name="action" value="del" readonly>
<input type = "hidden" name="mid" value ="${m.mid}">
<input type = "submit" value= "削除！">
</form>
</body>
</html>