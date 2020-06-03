<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
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
<h1>商品一覧！</h1>


<h3><c:if test="${not empty user}"><a href="insert.html">追加！</a></c:if><c:if test="${empty user}">追加！</c:if><a href="ulist">全売上一覧！</a></h3>
<table>
<tr><th>商品ＩＤ</th><th>商品名</th><th>単価(円)</th></tr>
<c:forEach var="shohin" items="${list}">
	<tr>
		<td>${shohin.sid}</td>
		<td>${shohin.name}</td>
		<td>${shohin.tanka}</td>
		<td><a href="uriage?sid=${shohin.sid}">売上</a></td>
		<td><c:if test="${not empty user}"><a href="update?sid=${shohin.sid}">変更</a></c:if><c:if test="${empty user}">変更</c:if></td>
		<td><c:if test="${not empty user}"><a href="del?sid=${shohin.sid}">削除</a></c:if><c:if test="${empty user}">削除</c:if></td>
	</tr>
</c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
<%@ include file="/common.jsp" %>
</body>
</html>