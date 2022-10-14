<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.isquibly.controller.ModelAttributeKeys" %>
<%@ page import="com.isquibly.controller.RequestMappings" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>View Add Items</title>
</head>
<body>
<div align="center">
        <tr>
            <td><label>ID</label></td>
            <td><c:out value="${id}"/></td>
        </tr>

        <tr>
            <td><label>Title</label></td>
            <td><c:out value="${title}"/></td>
        </tr>

        <tr>
            <td><label>Deadline</label></td>
            <td><c:out value="${deadline}"/></td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td><c:out value="${details}"/></td>
        </tr>

        <c:url var="listUrl" value="${RequestMappings.LIST_TODOS}" />
        <a href="${listUrl}">Back</a>
        <!--
        <a href="http://www.google.com">Back</a>
        -->
</div>
</body>
</html>