<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 08.01.2021
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2> Employee info!</h2>
    <br>
    <%-- без слеша перед действием!!!  --%>
    <form:form action="saveEmployee" modelAttribute="employee"> <%-- java forms --%>

        <form:hidden path="id"/> <%-- это поле id будет скрытым--%>

        Name <form:input path="name"/> <%-- set значения в поле name--%>
        <br>
        surname <form:input path="surname"/>
        <br>
        Department <form:input path="department"/>
        <br>
        Salary <form:input path="salary"/>
        <br>
        <input type="submit" name="OK"/>
    </form:form>
</body>
</html>
