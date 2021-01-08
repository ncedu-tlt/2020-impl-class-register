<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 07.01.2021
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Dear Student, Please enter your details!</h2>
    <br>
    <form:form action="showDetails" modelAttribute="student">
        Name <form:input path="name"/>
        <form:errors path="name"/> <%-- форма ответственная за ошибки --%>
        <br>
        Surename <form:input path="surename"/>
        <form:errors path="surename"/>
        <br>
        Scholarship <form:input path="scholarship"/>
        <form:errors path="scholarship"/>
        <br>
        Avarage Mark <form:input path="avarageMark"/>
        <br>
        Phone number <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
        <br>
        Email <form:input path="email"/>
        <form:errors path="email"/>
        <br>
        Flow <form:select path="flow">
            <form:options items="${student.flows}"/> //список возможных селекторов getFlows()
        </form:select>
        <br><br>

        What option do you want? <br>
        <form:radiobuttons path="prefInScholarship" items="${student.prefInScholarships}"/>
        <br><br>
        Foreign language(s)
        <form:checkboxes path="languages" items="${student.languagesList}"/>

        <input type="submit" value="OK">
    </form:form>
</body>
</html>
