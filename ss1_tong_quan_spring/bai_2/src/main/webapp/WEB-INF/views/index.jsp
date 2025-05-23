<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tra cứu từ</title>
</head>
<body>
<h1>Tra cứu từ điển</h1>
<form method="post" action="/search">
    <input type="text" name="word" placeholder="Nhập từ cần tìm">
    <input type="submit" value="Tìm kiếm">
</form>
<h2>Kết quả</h2>
<p>Từ khóa: ${word}</p>
<p>Nghĩa: ${meaning}</p>
</body>
</html>