<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo</title>
</head>
<body>
<h1>Memo</h1>
<ul>
<c:forEach var="m" items="${ml}">
	<li><a href="memo?mid=${m.mid}">${m.title}</a></li>
</c:forEach>
</ul>
</body>
</html>