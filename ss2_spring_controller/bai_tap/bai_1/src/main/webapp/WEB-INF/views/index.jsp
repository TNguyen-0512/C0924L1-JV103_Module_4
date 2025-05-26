<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form method="POST" action="/save">
    <c:forEach items="${condimentsList}" var="c">
        <label>
            <input type="checkbox" name="condiment" value="${c.name}" />${c.name}
        </label>
    </c:forEach>
    <br/>
    <input type="submit" value="Save">
</form>

</body>
</html>
