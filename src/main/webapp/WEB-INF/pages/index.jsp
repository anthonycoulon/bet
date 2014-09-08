<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container" id="login-block">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4">
            <div class="login-box">
                <div class="login-logo">
                    <a href="#" class="img-responsive"><img src="<c:url value="/resources/img/logo-valtech-ldc.png"/>"/></a>
                </div>
                <hr />
                <div class="login-form">
                    <form action="j_spring_security_check" method="post">
                        <input type="text" id="j_username" name="j_username" class="form-control" placeholder="Email" required/>
                        <input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" required/>
                        <button type="submit" class="btn btn-blue">Login</button>
                    </form>
                    <c:if test="${error!=null}">
                        <div class="error">${error}</<div>
                    </c:if>
                    <div class="login-links">
                        <a href="<c:url value="/myaccount/forgotpwd"/>">
                            Forgot password?
                        </a>
                        <br />
                        <a href="<c:url value="/myaccount/new"/>">
                            Don't have an account? <strong>Sign Up</strong>
                        </a>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
