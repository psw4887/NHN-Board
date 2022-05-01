<%@ page import="com.nhnacademy.data.Board" %>
<%@ page import="com.nhnacademy.repository.BoardRepository" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<html>
<head>
    <title>MasterBoard</title>
</head>
<body>
<%
    response.setContentType("text/html");
    out.println("" +
            "<table border=\"1\">\n" +
            "    <th>ID</th>\n" +
            "    <th>Writer</th>\n" +
            "    <th>Title</th>\n" +
            "    <th>Time</th>\n" +
            "    <th>View</th>");
    for (Board board : ((BoardRepository) application
                    .getAttribute("boardRepository"))
                    .getBoards()) {
        out.println("    <tr>\n" +
                "        <td>" + board.getId() + "</td>\n" +
                "        <td>" + board.getUserId() + "</td>\n" +
                "        <td><a href='/Board/content.jsp?content=" + board.getId() + "'>" + board.getTitle() + "</a></td>\n" +
                "        <td>" + board.getWriteTime()
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm:ss")) + "</td>\n" +
                "        <td>" + board.getViewCount() + "</td>\n" +
                "    </tr> ");
    }
    out.println("</table>");
%>
<a href="/board.do">Go to BoardManager</a>
</body>
</html>
