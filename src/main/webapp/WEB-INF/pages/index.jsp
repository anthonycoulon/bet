<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
	<form action="">
		<input type="" id="username"/>
		<br/>
		<input type="" id="password"/>
	</form>
	<c:forEach items="${users}" var="user">
		${user.username} <br/>
	</c:forEach>
</body>
</html>
