<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/flags.css"/>"/>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-ranking').addClass('active');
		})
	</script>
</head>
<body>
	<blockquote>
		<h3><b>${userDetail.userName}</b></h3>
		<h5 style="color: grey">Rank : ${userDetail.rank} | Score : ${userDetail.score}</h5>
	</blockquote>
	<c:choose>
		<c:when test="${empty userDetail.userBets}">
			<b>No user bets...</b>
		</c:when>
		<c:otherwise>
			<table class="table-responsive table table-striped">
				<c:forEach begin="0" end="${fn:length(userDetail.userBets)-1}" varStatus="b">
					<c:set value="${userDetail.userBets[b.index]}" var="bet"/>
					<tr>
						<td class="opponent1">
							${bet.oponent1}
						</td>
						<td class="flagM">
							<span class="famfamfam-flag-${bet.flag1}"></span>
						</td>
						<td class="score">${bet.bet}</td>
						<td class="flagM">
							<span class="famfamfam-flag-${bet.flag2}"></span>
						</td>
						<td class="opponent2">
							${bet.oponent2}
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
