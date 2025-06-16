<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Setting</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</head>
<body>
<h2>Settings</h2>
<form:form action="/settings" method="post" modelAttribute="email">
    <div class="mb-3">
        <label class="form-label">Languages</label>
        <form:select path="language" cssClass="form-select">
            <form:options items="${languages}"/>
        </form:select>
    </div>

    <div class="mb-3">
        <label class="form-label">Page Size:</label>
        Show
        <form:select path="pageSize" cssClass="form-select d-inline w-auto">
            <form:options items="${pageSizes}"/>
        </form:select> emails per page
    </div>

    <div class="form-check mb-3">
        <form:checkbox path="spamsFilter" cssClass="form-check-input"/>
        <label class="form-check-label">Enable spams filter</label>
    </div>

    <div class="mb-3">
        <label class="form-label">Signature:</label>
        <form:textarea path="signature" cssClass="form-control" rows="4"/>
    </div>

    <div class="mb-3">
        <input class="btn btn-sm btn-success" type="submit" value="Update"/>
        <button class="btn btn-sm btn-secondary" type="reset">Cancel</button>
    </div>
</form:form>
</body>
</html>