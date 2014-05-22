<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<form action="j_spring_security_check" method="post" id="form_login">
	<section class="row">
		<label for="j_username" class="col-lg-1">Login</label>
		<input type="text" id="j_username" name="j_username" class="col-lg-2"/>
	</section>
	<section class="row">
		<label for="j_password" class="col-lg-1">Password</label>
		<input type="password" id="j_password" name="j_password" class="col-lg-2"/>
	</section>
	<section class="row">
		<input type="submit" value="Connection"/>
		<c:if test="${error!=null}">
			<span class="error">${error}</span>
		</c:if>
	</section>
</form>
	<br/>
	<c:forEach items="${users}" var="user">
		${user.username} <br/>
	</c:forEach>
</body>
</html>
