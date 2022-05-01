<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><fmt:message key="Welcome" bundle="${la}" /> ${sessionScope.ss_id}</h1><br />
    <h2><fmt:message key="SingUpSuccess" bundle="${la}" /></h2>
    <h3><a href="/login.do"><fmt:message key="Login" bundle="${la}" /></a></h3>
<%
    session.invalidate();
%>
</body>
</html>
