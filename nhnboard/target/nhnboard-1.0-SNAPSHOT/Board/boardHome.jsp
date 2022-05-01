<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>boardHome</title>
</head>
<body>
<h2><fmt:message key="PostBoard" bundle="${la}" /></h2>
<form method="post" action="/masterBoard.do">
    <fmt:message key="Title" bundle="${la}" /> <input type="text" name="title"/><br />
    <fmt:message key="Content" bundle="${la}" /> <input type="text" name="context"/><br />
    <input type="submit" name="button" value="Post">
</form>
<h2><fmt:message key="ModifyBoard" bundle="${la}" /></h2>
<form method="post" action="/masterBoard.do">
    <fmt:message key="ID" bundle="${la}" /> <input type="text" name="beforeId"/><br />
    <fmt:message key="AfterTitle" bundle="${la}" /> <input type="text" name="title"/><br />
    <fmt:message key="AfterContent" bundle="${la}" /> <input type="text" name="context"/><br />
    <input type="submit" name="button" value="Modify">
</form>
<h2><fmt:message key="DeleteBoard" bundle="${la}" /></h2>
<form method="post" action="/masterBoard.do">
    <fmt:message key="ID" bundle="${la}" /> <input type="text" name="removeId"/><br /><br />
    <input type="submit" name="button" value="Delete">
</form>
<h2><fmt:message key="FindBoard" bundle="${la}" /></h2>
<form method="post" action="/masterBoard.do">
    <fmt:message key="ID" bundle="${la}" /> <input type="text" name="findBoard"/><br /><br />
    <input type="submit" name="button" value="Find">
</form>
<h4><fmt:message key="Find" bundle="${la}" /></h4>
<span><fmt:message key="ID" bundle="${la}" /> ${findThis.getId()}</span><br /><br />
<span><fmt:message key="userId" bundle="${la}" /> ${findThis.getUserId()}</span><br /><br />
<span><fmt:message key="Title" bundle="${la}" /> ${findThis.getTitle()}</span><br /><br />
<span><fmt:message key="Content" bundle="${la}" /> ${findThis.getContent()}</span><br /><br />
<h3><a href="/masterBoard.do"><fmt:message key="GoToBoardList" bundle="${la}" /></a></h3>
<h3><a href='/'><fmt:message key="GoHome" bundle="${la}" /></a></h3>
</body>
</html>
