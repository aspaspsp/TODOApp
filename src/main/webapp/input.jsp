<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<title>TODOアプリ入力画面</title>
<link rel="stylesheet" href="input.css">
<link rel="shortcut icon" href="images/favicon.ico">
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
--%>
</head>
<h1>TODOアプリケーション</h1>
<h2>TODO入力<h2>
<body>
<form action="InputServlet" method="post">

重要度：
<select name="rank" id="nn">
	<option value="">選択</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
</select><br>
    
内容：
<input type="text" name="content"><br>

期日：
<input type="date" id="mm" name="deadline"
       value=""
       min="2023-01-01" max="2023-12-31"><br>
       
<input type="submit" value="登録">
</form>
</body>
</html>