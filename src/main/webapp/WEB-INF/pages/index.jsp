<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>" />
</head>
<body>
<div class="container">
    <form action="j_spring_security_check" class="form-signin"  method="post" id="form_login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" id="j_username" name="j_username" class="input-block-level" placeholder="Email"/>
        <input type="password" id="j_password" name="j_password" class="input-block-level" placeholder="Password"/>
        <input type="submit" value="Sign in"
               class="btn btn-large btn-primary"/>
        <c:if test="${error!=null}">
            <span class="error">${error}</span>
        </c:if>
    </form>
</div>
</body>
</html>
