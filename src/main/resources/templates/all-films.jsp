<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>All film list</h2>
<br><br>

<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Year of issue</th>
        <th>Producer</th>
    </tr>

    <jsp:useBean id="allFilms" scope="request" type="java.util.List"/>
    <c:forEach var="film" items="${allFilms}">
        <tr>
            <td>${film.name}</td>
            <td>${film.description}</td>
            <td>${film.yearOfIssue}</td>
            <td>${film.producer}</td>
        </tr>
    </c:forEach>


</table>
<br><br>
<input type="button" value="add"
onclick="window.location.href='addFilm'">

</body>


</html>