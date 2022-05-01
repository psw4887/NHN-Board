<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nhnacademy.data.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<fmt:setLocale value="${lang}" />
<!Doctype>
<html>
<head>
  <meta charset="UTF-8">
  <title>UserManage</title>
</head>
<h2><fmt:message key="UserList" bundle="${la}" /></h2>
<%
  for (User user : (List<User>) application.getAttribute("userList")) {
    response.setContentType("text/html");
    out.println(user.getId() + "<br />");
  } %>
<h2><fmt:message key="AddUser" bundle="${la}" /></h2>
<form method="post" action="/user.do">
  <fmt:message key="Name" bundle="${la}" /> <input type="text" name="addName"/><br />
  <fmt:message key="ID" bundle="${la}" /> <input type="text" name="addId"/><br />
  <fmt:message key="PW" bundle="${la}" /> <input type="password" name="addPwd"/><br />
<input type="submit" name="button" value="Add">
</form>
<h2><fmt:message key="ModifyUser" bundle="${la}" /></h2>
<form method="post" action="/user.do">
  <fmt:message key="ID" bundle="${la}" /> <input type="text" name="beforeId"/><br />
  <fmt:message key="AfterId" bundle="${la}" /> <input type="text" name="afterId"><br />
  <fmt:message key="AfterPw" bundle="${la}" /> <input type="password" name="afterPwd"><br /><br />
  <input type="submit" name="button" value="Modify">
</form>
<h2><fmt:message key="DeleteUser" bundle="${la}" /></h2>
<form method="post" action="/user.do">
  <fmt:message key="ID" bundle="${la}" /> <input type="text" name="removeId"/><br /><br />
  <input type="submit" name="button" value="Delete">
</form>
<h2><fmt:message key="FindUser" bundle="${la}" /></h2>
<form method="post" action="/user.do">
  <fmt:message key="ID" bundle="${la}" /> <input type="text" name="findId"/><br /><br />
  <input type="submit" name="button" value="Find">
</form>
<h4>Find<br /></h4>
 <fmt:message key="ID" bundle="${la}" /> ${findUser.getId()}<br /><br />
 <fmt:message key="File" bundle="${la}" /><img src='/image.do?content=${findUser.getProfileFileName()}'><br /><br />
<a href='/'><fmt:message key="GoHome" bundle="${la}" /></a>
</body>
</html>
