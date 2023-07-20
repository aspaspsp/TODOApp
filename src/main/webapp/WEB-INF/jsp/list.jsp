<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
<style>
.logout{
float: right;
}
</style>
</head>
<body>
<a herf="Logoutservlet" class="logout">ログアウト</a>
<h1>TODOアプリケーション</h1>
<h2><c:out value="${loginuser.name}"/></h2>
<p class="error">${errorMsg}</p>
<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<c:forEach var="todo" items="${todoList}" varStatus="status">
<tr><td>${status.count}</td><td>${todo.rank}</td><td>${todo.content}</td><td>${todo.deadline}</td></tr>
</c:forEach>
</table><br>
<!-- 変更 -->
<from action="Updateservlet" method="post">
変更No<select name="no">
<c:forEach items="${todoList}"varStatus="status">
<option value="${status.index}">${status.count}</option>
</c:forEach>
</select>
<select name="rank">
<option value="5">5</option>
<option value="4">4</option>
<option value="3">3</option>
<option value="2">2</option>
<option value="1">1</option>
</select>
内容:<input type="text" name="content">
期日:<input type="date" name="deadline">
<input type="submit" value="変更">
</form>
<!-- 削除 -->
<form action="DeleteSevlet" method="post">
変更No<select name="no">
<option value="0">1</option>
</select>
<input type="submit" value="削除>
</form>
</body>
</html>