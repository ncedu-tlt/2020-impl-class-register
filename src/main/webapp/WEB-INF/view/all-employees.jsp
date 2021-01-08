<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2> All employees </h2>
        <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Operation</th>
        </tr>

        <c:forEach var="emp" items="${allEmps}">

            <c:url var="updateButton" value="/updateInfo"> <%-- url с айдишником элемента--%>
                <c:param name="empId" value="${emp.id}"/>
            </c:url>

            <tr>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <%-- при нажатии на кнопу мы будем переходить по ссылке в метод --%>
                    <input type="button" value="Update"
                           onclick="window.location.href = '${updateButton}'"/>
                </td>
            </tr>

        </c:forEach>
    </table>
    <br>
<%--  при нажатии на кнопу будет вызваться метод addNewEmployee --%>
<input type="button" value="Add"
   onclick="window.location.href = 'addNewEmployee'">


</body>
</html>