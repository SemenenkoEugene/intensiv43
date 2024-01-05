<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All actors</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>

    <jsp:useBean id="allActors" scope="request" type="java.util.List"/>
    <c:forEach var="act" items="${allActors}">
        <tr>
            <td>${act.name}</td>
            <td>${act.age}</td>
        </tr>

    </c:forEach>

</table>


</body>
</html>