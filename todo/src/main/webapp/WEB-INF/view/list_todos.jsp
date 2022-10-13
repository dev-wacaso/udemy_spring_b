<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.isquibly.controller.RequestMappings" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
        <c:url var ="addUrl" value="${RequestMappings.ADD_EDIT_TODO}" />
        <a href="${addUrl}">New Todo</a>
        <c:if test="${!todoService.getTodos().isEmpty()}">
            <form:form method="GET">
                <table>
                    <caption><h2>Todo Items</h2></caption>
                    <tr>
                        <th>Title</th>
                        <th>Deadline</th>
                        <th></th>
                    </tr>
                    <c:forEach var="item" items="${todoService.getTodos()}">
                        <!-- Edit -->
                        <c:url var="editUrl" value="${RequestMappings.ADD_EDIT_TODO}">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>

                        <!-- Delete -->
                        <c:url var="deleteUrl" value="${RequestMappings.DELETE_TODO}">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <tr>
                            <td><c:out value="${item.title}" /></td>
                            <td><a href="${editUrl}"><img src="/images/edit_21x21.png" /></a></td>
                            <td><c:out value="${item.deadline}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </form:form>
        </c:if>

        <c:if test="${todoService.getTodos().isEmpty()}">
            <h1>Number of items left <c:out value="${todoService.getTodos().size()}"/></h1>
            <h3>No items to display....why not add some?</h3>
        </c:if>

    </div>
</body>
</html>