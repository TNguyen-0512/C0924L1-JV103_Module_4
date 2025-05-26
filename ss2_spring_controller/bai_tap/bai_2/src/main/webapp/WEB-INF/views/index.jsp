<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form method="post" action="/caculator">
    <input type="number" name="numA"/>
    <input type="number" name="numB"/>
    <br/><br/>
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(X)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>
<c:if test="${not empty result}">
    <p><strong>Result ${message} :</strong> ${result}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red;"><strong>${error}</strong></p>
</c:if>
</body>
</html>