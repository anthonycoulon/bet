<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript" src="<c:url value="/resources/js/Matches.js"/>"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/match.css"/>"/>
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
	<section id="matches">
		<c:forEach items="${dtos}" var="dto">
			<section class="row col-lg-12 col-md-12 col-sm-12">
				<input class="betId" type="hidden" value="${dto.betId}"/>
				<input class="matchId" type="hidden" value="${dto.matchId}"/>
				<div ><b>${dto.opponent1}</b></div>
				<div class="score">
					${dto.score}
				</div>
				<div class="bet">
					<input type="text" class="bet1 bet" value="${dto.bet1}"/> - <input type="text" class="bet2 bet" value="${dto.bet2}"/>
				</div>
				<div ><b>${dto.opponent2}</b></div>
			</section>
		</c:forEach>
	</section>
	<section class="row">
		<input type="button" value="Save" id="save_button" class="btn btn-large btn-primary"/>
	</section>
	<script type="text/javascript">
		new Matches().init();
	</script>
</body>
</html>
