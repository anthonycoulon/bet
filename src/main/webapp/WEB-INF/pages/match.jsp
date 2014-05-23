<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<label for="dates">Day : </label>
		<select name="dates" id="dates">
			<c:forEach items="${dates}" var="date">
				<c:choose>
					<c:when test="${date==today}">
						<option value="${date.time}" selected="selected"><fmt:formatDate value="${date}"
						                                                                 pattern="dd/MM/yyyy"/></option>
					</c:when>
					<c:otherwise>
						<option value="${date.time}"><fmt:formatDate value="${date}" pattern="dd/MM/yyyy"/></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</section>
	<c:forEach items="${dtos}" var="dto">
		<section class="row">
			<span class="col-lg-2 col-md-2 col-sm-2"><b>${dto.opponent1}</b></span>
			<span class="col-lg-2 col-md-2 col-sm-2">
				<c:if test="${dto.score1!=null}">
					${dto.score1}-${dto.score2} /
				</c:if>
				<input type="text" class="bet1 bet" value="${dto.bet1}"/>
				-
				<input type="text" class="bet2 bet" value="${dto.bet2}"/></span>
			<span class="col-lg-2 col-md-2 col-sm-2"><b>${dto.opponent2}</b></span>
		</section>
	</c:forEach>
</body>
</html>
