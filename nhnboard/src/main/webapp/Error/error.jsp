<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>Error</title>
</head>
<body>
  <h1><fmt:message key="Error" bundle="${la}" /></h1><br />
    <h2><fmt:message key="Sorry" bundle="${la}" /></h2>
</body>
</html>
