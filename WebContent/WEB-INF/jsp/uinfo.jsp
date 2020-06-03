<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上詳細</title>
<style>
td,th{
	padding:0.2em 0.5em;
}
th{
	text-align:right;
}
</style>
</head>
<body>
<h3>売上詳細！</h3>
<table>
<tr><th>売上ID:</th><td>${uinfo.uid }</td></tr>
<tr><th>商品ID:</th><td>${uinfo.sid }</td></tr>
<tr><th>商品名:</th><td>${sinfo.name }</td></tr>
<tr><th>単価:</th><td>${sinfo.tanka } 円</td></tr>
<tr><th>個数:</th><td>${uinfo.kosu } 個</td></tr>
<tr><th>金額:</th><td>${sinfo.tanka * uinfo.kosu } 円</td></tr>
<tr><th>日付:</th><td>${uinfo.hi }</td></tr>
</table>
</body>
</html>