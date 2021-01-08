<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 07.01.2021
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Dear Student, you're WELCOME!!!</h2>
    <br>
    Your name: ${student.name}!
    <br>
    Your surename: ${student.surename}!
    <br>
    Your scholarship: ${student.scholarship}!
    <br>
    Your avarage mark: ${student.avarageMark}!
    <br>
    Your phone number: ${student.phoneNumber}!
    <br>
    Your email: ${student.email}!
    <br>
    Your Class: ${student.flow}!
    <br>
    Your choice: ${student.prefInScholarship}!
    <br>
    Language(s):
    <ul> <%-- unordered list --%>
        <c:forEach var="lang" items="${student.languages}">
            <li> ${lang} </li> <%--list item--%>
        </c:forEach>
    </ul>
</body>
</html>
