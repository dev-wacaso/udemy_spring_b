<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.isquibly.controller.AttributeNames" %>

<!--
https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/spring-form-tld.html
-->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Item</title>
</head>
<body>
<div align="center">
    <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}">

    </form:form>
</div>


</body>
</html>