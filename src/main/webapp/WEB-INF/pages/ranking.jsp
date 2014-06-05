<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-ranking').addClass('active');
		})
	</script>
</head>
<body>
	<table id="ranking" class="table-responsive table table-striped">
		<thead>
			<th>Rank</th>
			<th>User</th>
			<th>Score</th>
		</thead>
		<tbody>
			<c:forEach begin="0" end="${fn:length(users)-1}" varStatus="u">
				<c:choose>
					<c:when test="${users[u.index].userId==userId}">
						<tr style="font-weight:bold; color: #5cb85c;">
							<td>${users[u.index].rank}</td>
							<td>${users[u.index].userName}</td>
							<td>${users[u.index].score}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${users[u.index].rank}</td>
							<td>${users[u.index].userName}</td>
							<td>
								<c:choose>
									<c:when test="${empty users[u.index].score}">
										0
									</c:when>
									<c:otherwise>
										${users[u.index].score}
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
