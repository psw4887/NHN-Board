<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1><fmt:message key="Hello" bundle="${la}"/>, ${ss_id}</h1>
    <h3><a href='/board.do'><fmt:message key="GoToBoard" bundle="${la}"/></a></h3><br />
    <h3><a href='/logout.do'><fmt:message key="Logout" bundle="${la}"/></a></h3><br /><br />
    <h3><a href='/'><fmt:message key="GoHome" bundle="${la}"/></a></h3>
</body>
</html>
