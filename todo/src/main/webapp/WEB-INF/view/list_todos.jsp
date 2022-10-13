<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Todo Items</title>
</head>
<body>

<h1>TODO</h1>
<hr/>
    <ul>
        <c:forEach var="item" items="${todoService.getTodos()}">
            <li><c:out value="${item.getTitle()}" /></li>
        </c:forEach>
    </ul>

    <div align="center">
        <form:form method="GET">
            <table>
                <caption><h2>Todo Items</caption>
                <tr>
                    <th>Title</th>
                    <th>Deadline</th>
                    <th>X</th>
                </tr>
                <c:forEach var="item" items="${todoService.getTodos()}">
                    <tr><td><c:out value="${item.getTitle()}" /></td>
                    <td><c:out value="${item.getDeadline()}" /></td>
                    <td><form:button id="btnDelete" name="btnDelete" value="X"/></td></tr>
                </c:forEach>

            </table>
        </form:form>
    </div>
</body>
</html>