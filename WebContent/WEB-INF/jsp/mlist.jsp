<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員一覧</title>
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
<h1>会員一覧！</h1>
<form action="mlist" method="post">
氏名？：<input type = "text" name="name"><br>
住所？：<input type = "text" name="adr"><br>
<input type = "submit" value = "追加！">
</form>

<table>
<tr><th>氏名</th><th>住所</th></tr>
<c:forEach var="mlist" items="${list}">
	<tr>
		<td><a href="mupdate?mid=${mlist.mid}"><c:out value="${mlist.name}"/></a></td>
		<td><c:out value="${mlist.adr}"/></td>
	</tr>
</c:forEach>
</table>
</body>
</html>