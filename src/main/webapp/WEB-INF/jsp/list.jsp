<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="stylesheet" href="list.css">
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2><c:out value="${loginuser.name}"/></h2>
<p class="error">${errorMsg}</p>
<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<tr><td>1</td><td>${todo.rank}</td><td>${todo.content}</td><td>${todo.deadline}</td></tr>
</c:if>
</table><br>
<!-- 変更 -->
<from action="Updateservlet" method="post">
変更No<select name="no">
<opton value="0">1</opton>
</select>
<select name="priority">
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