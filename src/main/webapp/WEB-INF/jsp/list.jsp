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
<h2>村田遥夢のTODOリスト<h2>

<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<tr><td>1</td><td>${todo.rank}</td><td>${todo.content}</td><td>${todo.deadline}</td></tr>
</table>

<a href="/J2A324/input.jsp">戻る</a></body>

</body>
</html>