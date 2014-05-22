<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<form action="j_spring_security_check" class="form-signin"  method="post" id="form_login">
	<section class="row">
		<label for="j_username" class="col-lg-1 col-md-1 col-sm-1">Login</label>
		<input type="text" id="j_username" name="j_username" class="col-lg-2 col-md-2 col-sm-2 input-block-level"/>
	</section>
	<section class="row">
		<label for="j_password" class="col-lg-1 col-md-1 col-sm-1">Password</label>
		<input type="password" id="j_password" name="j_password" class="col-lg-2 col-md-2 col-sm-2 input-block-level"/>
	</section>
	<section class="row">
		<input type="submit" value="Sign in"
		       class="col-lg-1 col-md-1 col-sm-1 col-lg-offset-2 col-md-1 col-md-offset-2 col-sm-1 col-sm-offset-2 btn btn-large btn-primary"/>
	</section>
	<c:if test="${error!=null}">
		<section class="row">
			<span class="error">${error}</span>
		</section>
	</c:if>
</form>
	<br/>
	<c:forEach items="${users}" var="user">
		${user.username} <br/>
	</c:forEach>
</body>
</html>
