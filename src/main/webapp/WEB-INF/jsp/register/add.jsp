<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form:form method="post" modelAttribute="user">
    Email: <form:input path="email"/>
    Password: <form:password path="password"/>
    First name: <form:input path="firstName"/>
    Second name: <form:input path="secondName"/>
    <input type = "submit" value = "Zarejestruj"/>
</form:form>