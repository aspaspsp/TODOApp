<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
</head>
<body>
<form action="LoginServlet" method="post">
<h1>TODOアプリケーション</h1>
<h2>ログイン</h2>
<p>
<c:out value="${loginUser.name}" />さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg}">
  <p>${errorMsg}</p>
</c:if>
<c:forEach var="mutter" items="${mutterList}">
　<p><c:out value="${mutter.userName}" />：<c:out value="${mutter.text}" /></p>
</form>
</c:forEach>
</body>
</html>