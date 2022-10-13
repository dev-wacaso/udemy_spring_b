<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.isquibly.controller.ModelAttributeKeys" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Items</title>
</head>
<body>
<div align="center">
    <form:form method="POST" modelAttribute="${ModelAttributeKeys.TODO}">
        <table>
        <tr>
            <td><label>ID</label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><label>Title</label></td>
            <td><form:input path="title" /></td>
        </tr>

        <tr>
            <td><label>Deadline</label></td>
            <td><form:input path="deadline" /></td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td><form:textarea path="details" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
        </table>
    </form:form>
</div>
</body>
</html>