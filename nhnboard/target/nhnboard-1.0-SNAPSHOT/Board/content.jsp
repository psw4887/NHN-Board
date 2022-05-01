<%@ page import="com.nhnacademy.repository.BoardRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    BoardRepository repo = (BoardRepository) request.getServletContext().getAttribute("boardRepository");
    repo.getBoard(Long.parseLong(request.getParameter("content"))).increaseViewCount();
    response.setContentType("text/html");
    out.println(
        "<h2>" + repo.getBoard(Long.parseLong(request.getParameter("content"))).getContent() + "</h2>"
    );
%>
<h3><a href="/Board/masterBoard.jsp"><fmt:message key="GoToBoardList" bundle="${la}" /></a></h3>
</body>
</html>
