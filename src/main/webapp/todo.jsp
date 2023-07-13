<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Random" %>

<%   

//内容をランダムで決定
String[] todoList = { "Linuxテスト対策", "paiza", "TODOアプリ作成", "履歴書" };

//実行日を取得
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
String today = sdf.format(date);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
</head>
<body>

<h1>TODOアプリケーション</h1>
<h2>村田遥夢のTODOリスト<h2>

<table border=1>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>
<tr>
<% for (int i = 1 ; i < 11 ; i++) { 
Random rand = new Random();
int num = rand.nextInt(todoList.length);
String todo = todoList[num];%>
<td><%= i%></td><td> <%= num + 1 %> </td><td> <%= todo %> </td><td> <%= today %> </td>
</tr>
<% } %>
</table>
</body>
</html>