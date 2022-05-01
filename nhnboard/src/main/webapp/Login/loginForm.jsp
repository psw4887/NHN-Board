<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form method="post" action="/login.do">
    <h3><fmt:message key="ID" bundle="${la}" /><input type="text" name="id"></h3>
    <h3><fmt:message key="PW" bundle="${la}" /><input type="password" name="pwd"></h3>

    <input type="submit" value="Login">
</form>
</body>
</html>