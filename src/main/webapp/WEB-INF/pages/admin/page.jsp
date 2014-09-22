<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script type="text/javascript" src="<c:url value="/resources/js/admin/Admin.js"/>"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/>"/>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-admin').addClass('active');
		})
	</script>
</head>
<body>
	<section>
		<label class="control-label" for="run-button">Run calculate score task</label>
		<input type="button" value="Run" id="run-button" class="btn btn-large btn-blue"/>
	</section>
	<section>
		<input type="button" value="Save" id="save-button" class="btn btn-large btn-blue"/>
	</section>
	<table id="matches" class="table-responsive table table-striped">
		<thead>
			<tr>
				<th>Date</th>
				<th  class="opponent1">#1</th>
				<th  class="score">Score</th>
				<th  class="opponent2">#2</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="0" end="${fn:length(matches)-1}" varStatus="m">
				<c:set value="${matches[m.index]}" var="match"/>
				<tr>
					<td style="display:none;">
						<input type="hidden" id="id" value="${match.id}"/>
					</td>
					<td>
						<fmt:formatDate value="${match.matchTime}" pattern="dd/MM /yyyy"/>
					</td>
					<td class="opponent1">
						${match.opponent1}
					</td>
					<td class="score">
						<input type="text" id="score" value="${match.score}" class="form-control"/>
					</td>
					<td class="opponent2">
						${match.opponent2}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<section>
		<input type="button" value="Save" id="save-button" class="btn btn-large btn-blue"/>
	</section>
	<script type="text/javascript">
		new Admin().init();
	</script>
</body>
</html>
