<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-match').addClass('active');
		})
	</script>
</head>
<body>
<section class="row">
	User : ${user}
</section>
<c:forEach items="${dtos}" var="dto">
	<section class="row">
		<span>${dto.opponent1}</span>
		<span>${dto.score1}-${dto.score2}</span>
		<span>${dto.opponent2}</span>
	</section>
</c:forEach>
</body>
</html>
