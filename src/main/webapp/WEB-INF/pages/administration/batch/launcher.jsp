<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script type="text/javascript">
		$(function() {
			activateTab('tab_admin');
			activateMenu('menu_admin', 'menu_admin_lanceur_batch');
		});
	</script>
</head>
<body>
	<br/>
	<br/>
	<div id="batches">
		<c:forEach var="batch" items="${batchs}">
			<c:set var="url" value="${pageContext.request.contextPath}/administration/batch/launcher/launchAndGoHome/${batch.key}" />
			<a class="listeLien-rouge-inv" href="${url}" onclick="return confirm('Etes-vous s&ucirc;r de vouloir ex&eacute;cuter ce batch ?');">${batch.value}</a>
		</c:forEach>
	</div>
</body>
</html>
