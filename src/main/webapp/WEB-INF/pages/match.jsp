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
					<c:when test="${date.time eq today.time}">
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
	<table id="matches" class="table-responsive table table-striped">
		<thead>
			<th></th>
			<th>Time</th>
			<th>Opponent #1</th>
			<th>Score</th>
			<th>Bet</th>
			<th>Opponent #2</th>
		</thead>
		<tbody>
			<c:forEach items="${dtos}" var="dto">
				<tr>
					<td>
						<input class="betId" type="hidden" value="${dto.betId}"/>
						<input class="matchId" type="hidden" value="${dto.matchId}"/>
					</td>
					<td>
						<input type="hidden" value="${dto.matchTime.time}" class="matchTime"/>
						<fmt:formatDate value="${dto.matchTime}" pattern="hh:mm a"/>
					</td>
					<td>
						${dto.opponent1}
					</td>
					<td>
						${dto.score}
					</td>
					<td class="bet">
						<input type="text" class="bet1 bet" value="${dto.bet1}"/> - <input type="text" class="bet2 bet" value="${dto.bet2}"/>
					</td>
					<td>
						${dto.opponent2}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<section class="row">
		<input type="button" value="Save" id="save_button" class="btn btn-large btn-primary"/>
	</section>
	<script type="text/javascript">
		new Matches().init();
	</script>
</body>
</html>
