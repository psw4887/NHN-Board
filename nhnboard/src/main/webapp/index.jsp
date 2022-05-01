<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="tt" var="la" scope="application"/>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <h1>NHN Board</h1>

    <h4><a href="/lang.do"><fmt:message key="lang" bundle="${la}" /></a></h4>
    <h3><a href="/board.do"><fmt:message key="GoToBoard" bundle="${la}" /></a></h3>
    <h3><a href="/Join/JoinForm.jsp"><fmt:message key="SignUp" bundle="${la}" /></a></h3>
    <h3><a href="/login.do"><fmt:message key="Login" bundle="${la}" /></a></h3>
    <h3><a href="/logout.do"><fmt:message key="Logout" bundle="${la}" /></a></h3>
</body>
<%
    session.invalidate();
%>
</html>