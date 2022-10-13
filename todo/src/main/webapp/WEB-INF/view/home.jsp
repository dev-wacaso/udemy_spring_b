<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.isquibly.controller.RequestMappings" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Todo List Application</title>
</head>
<body>
    <div align="center">
        <c:url  var="itemsLink"  value="${RequestMappings.LIST_TODOS}" />
        <h2><a  href="${itemsLink}">Show Todo Items</a></h2>
    </div>
</body>
</html>