<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript" src="<c:url value="/resources/js/Matches.js"/>"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/match.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/logos.css"/>"/>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-match').addClass('active');
		})
	</script>
</head>
<body>
	<div class="hero-unit">
		<c:choose>
			<c:when test="${empty user.score}">
				<p>Hello ${user.firstName}! Your <b>score</b> is <b>0</b>.</p>
			</c:when>
			<c:otherwise>
				<p>Hello ${user.firstName}! Your <b>score</b> is <b>${user.score}</b>.</p>
			</c:otherwise>
		</c:choose>
	</div>
	<section>
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
	<c:choose>
		<c:when test="${empty dtos}">
			<span id="no-match"><b>There is no match today! Select another date in list box.</b></span>
		</c:when>
		<c:otherwise>
			<span id="no-match" style="display: none"><b>There is no match today! Select another date in list box.</b></span>
		</c:otherwise>
	</c:choose>

	<table id="matches" class="table-responsive table table-condensed">
		<tbody>
			<c:forEach items="${dtos}" var="dto">
                <tr class="firstLine">
					<td colspan="5">
						<input class="matchId" type="hidden" value="${dto.matchId}"/>
						${dto.matchLevel}
						<input type="hidden" value="${dto.matchTime.time}" class="matchTime"/>
						&nbsp;-&nbsp;
						<fmt:formatDate value="${dto.matchTime}" pattern="KK:mm a"/>
					</td>
                </tr>
                <tr>
					<td class="opponent1">
						<c:choose>
							<c:when test="${dto.winner==1}">
								<b>${dto.opponent1}</b>
							</c:when>
							<c:otherwise>
								${dto.opponent1}
							</c:otherwise>
						</c:choose>
					</td>
					<td class="flag">
						<span class="sp-${dto.flag1}"></span>
					</td>
					<td class="score">
						<c:choose>
							<c:when test="${empty dto.score}">
								-
							</c:when>
							<c:otherwise>
								<b>${dto.score}</b>
							</c:otherwise>
						</c:choose>
					</td>
					<td class="flag">
						<span class="sp-${dto.flag2}"></span>
					</td>
					<td class="opponent2">
						<c:choose>
							<c:when test="${dto.winner==2}">
								<b>${dto.opponent2}</b>
							</c:when>
							<c:otherwise>
								${dto.opponent2}
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr class="line-bet">
					<td>
						Bet :
					</td>
					<td colspan="3" class="bet">
						<input type="text" class="bet1 bet form-control" value="${dto.bet1}"/> - <input type="text" class="bet2 bet form-control" value="${dto.bet2}"/>
					</td>
					<td colspan="3">
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
	<section>
		<input type="button" value="Save" id="save_button" class="btn btn-large btn-blue"/>
	</section>
	<script type="text/javascript">
		new Matches().init();
	</script>
</body>
</html>
