<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/flags.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/detail.css"/>"/>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-ranking').addClass('active');
		})
	</script>
</head>
<body>
	<blockquote id="title">
		<c:if test="${userDetail.hasAvatar}">
			<img src="/bet/ranking/user/detail/avatar/${userId}" alt="avatar" class="img-responsive avatar user-avatar"/>
		</c:if>
		<section>
			<h3><b>${userDetail.userName}</b></h3>
			<h5>Rank : ${userDetail.rank} | Score :
				<c:choose>
					<c:when test="${userDetail.score==null}">
						0
					</c:when>
					<c:otherwise>
						${userDetail.score}
					</c:otherwise>
				</c:choose>
			</h5>
		</section>
	</blockquote>
	<c:choose>
		<c:when test="${empty userDetail.userBets}">
			<b>No bet...</b>
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
