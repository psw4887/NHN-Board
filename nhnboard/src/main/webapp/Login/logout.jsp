<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>Logout</title>
</head>
<body>
<h1><fmt:message key="GoodBye" bundle="${la}" /> ${ss_id}</h1><br />
<h3><fmt:message key="SeeNT" bundle="${la}" /></h3>
<a href='/'><fmt:message key="GoHome" bundle="${la}" /></a>
<%
    session.invalidate();
%>
</body>
</html>
