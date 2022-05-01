<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <meta charset="UTF-8">
    <title>Join</title>
</head>
<body>
    <form method="post" action="/join.do" enctype="multipart/form-data">
        <fmt:message key="Name" bundle="${la}" /> <input type="text" name="name"/><br /><br />
        <fmt:message key="ID" bundle="${la}" /> <input type="text" name="id"/><br /><br />
        <fmt:message key="PW" bundle="${la}" /> <input type="password" name="pwd"/><br /><br />
        <fmt:message key="File" bundle="${la}" /> <input type="file" name="f1" /><br /><br />
        <input type="submit" name="button" value="Complete"/>
    </form>
</body>
</html>
