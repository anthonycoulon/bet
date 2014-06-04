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
<div class="hero-unit">
    <p>Hello ${user.firstName}! Your <b>score</b> is <b>${user.score}</b>.</p>
</div>
	<section class="row">
		<label for="dates">Day : </label>
		<select name="dates" id="dates" class="form-control">
			<option value="none"></option>
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
	<table id="matches" class="row table-responsive table table-striped">
		<thead>
			<th>Level</th>
			<th>Time</th>
			<th>#1</th>
			<th>Score</th>
			<th>#2</th>
		</thead>
		<tbody>
			<c:forEach items="${dtos}" var="dto">
				<tr>
					<td style="display: none;">
						<input class="betId" type="hidden" value="${dto.betId}"/>
						<input class="matchId" type="hidden" value="${dto.matchId}"/>
					</td>
					<td>
						${dto.matchLevel}
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
					<td>
						${dto.opponent2}
					</td>
				</tr>
				<tr>
					<td>
						<b>Bet : </b>
					</td>
					<td colspan="2" class="bet">
						<input type="text" class="bet1 bet form-control" value="${dto.bet1}"/> - <input type="text" class="bet2 bet form-control" value="${dto.bet2}"/>
					</td>
					<td colspan="2">
						<div class="progress">
							<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${dto.odds1}" aria-valuemin="0" aria-valuemax="100"
							     style="width: ${dto.odds1}%;">
								${dto.odds1}%
							</div>
							<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${dto.odds2}" aria-valuemin="0" aria-valuemax="100"
							     style="width: ${dto.odds2}%;">
								${dto.odds2}%
							</div>
						</div>
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
