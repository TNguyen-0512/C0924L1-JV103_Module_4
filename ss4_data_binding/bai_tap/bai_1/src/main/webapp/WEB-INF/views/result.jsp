<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Settings Result</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
  <h2>Settings Updated</h2>
  <table class="table table-bordered w-50">
    <tr>
      <th>Language</th>
      <td>${setting.language}</td>
    </tr>
    <tr>
      <th>Page Size</th>
      <td>${setting.pageSize}</td>
    </tr>
    <tr>
      <th>Spams Filter</th>
      <td>
        <c:choose>
          <c:when test="${setting.spamsFilter}">Enabled</c:when>
          <c:otherwise>Disabled</c:otherwise>
        </c:choose>
      </td>
    </tr>
    <tr>
      <th>Signature</th>
      <td>${setting.signature}</td>
    </tr>
  </table>

  <a class="btn btn-primary" href="/">Back to Settings</a>
</div>
</body>
</html>
