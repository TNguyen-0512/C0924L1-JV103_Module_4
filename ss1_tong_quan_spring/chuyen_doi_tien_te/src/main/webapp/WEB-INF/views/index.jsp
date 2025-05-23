<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chuyển Đổi Tiền Tệ</title>
</head>
<body>
<div class="container">
    <h1>Chuyển Đổi Tiền Tệ</h1>
    <form action="/doi" method="post">
        <label>Nhập tỷ giá:</label>
        <input type="number" name="rate"  required><br><br>
        <label>USD - Đô La Mỹ:</label>
        <input type="number" name="usd" required><br><br>
        <input type="submit" value="Đổi">
    </form>
    <c:if test="${not empty vnd}">
        <h3>${usd} USD = ${vnd} VND (Tỉ giá: ${rate})</h3>
    </c:if>
</div>
</body>
</html>

