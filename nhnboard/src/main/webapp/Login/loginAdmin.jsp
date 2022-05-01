<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1><fmt:message key="Hello" bundle="${la}" /> ${ss_id}</h1><br />
<h3><a href="/board.do"><fmt:message key="GoToBoard" bundle="${la}" /></a></h3>
<h3><a href="/user.do"><fmt:message key="UserManager" bundle="${la}" /></a></h3>
<h3><a href='/'><fmt:message key="GoHome" bundle="${la}" /></a></h3>
</body>
</html>
