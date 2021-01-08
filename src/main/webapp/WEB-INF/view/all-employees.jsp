<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2> All employees! </h2>
        <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Surename</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="emp" items="${allEmps}">
            <tr>
                <td>${emp.name}</td>
                <td>${emp.surename}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
<%--  при нажатии на кнопу будет вызваться метод addNewEmployee --%>
<input type="button" value="Add"
   onclick="window.location.href = 'addNewEmployee'">


</body>
</html>