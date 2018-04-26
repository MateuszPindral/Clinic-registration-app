<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>


<h2>Dodaj nowe konto.</h2>
<form:form action="nowyPacjent/zarejestruj" method="post" modelAttribute="newPatient">
    <label>Imię:</label><br>
    <form:input type="text" path="firstName"/><br>
    <label>Nazwisko:</label><br>
    <form:input type="text" path="lastName"/><br>
    <label>E-mail:</label><br>
    <form:input path="email"/><br>
    <label>Login:</label><br>
    <form:input path="login"/><br>
    <label>Hasło(minimum 7 znaków):</label><br>
    <form:input type="password" path="password"/><br>
    <label>Powtórz hasło:</label><br>
    <form:input type="password" path="matchingPassword"/><br>
    <input type="submit" value="Wyślij"><br>
</form:form>
</html>
