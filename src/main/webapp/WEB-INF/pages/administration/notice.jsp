<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script type="text/javascript">
			$(function() {
				activateTab('tab_admin');
				activateMenu('menu_admin', 'menu_admin_notice');
			});
		</script>
	</head>
	<body>
		<form id="uploadForm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="moduleCode" value="${moduleCode}">
			Importer la notice : <input type="file" name="file">
			<input type="submit" value="Importer">
		</form>
		<c:if test="${not empty error}">
			<br/>
			<div style="padding: 0 .7em;" class="ui-state-error ui-corner-all">
				<p><span style="float: left; margin-right: .3em;" class="ui-icon ui-icon-alert"></span>
				<strong>Erreur :</strong> ${error}</p>
			</div>
		</c:if>
		<c:if test="${not empty info}">
			<div style="margin-top: 20px; padding: 0 .7em;" class="ui-state-highlight ui-corner-all">
				<p><span style="float: left; margin-right: .3em;" class="ui-icon ui-icon-info"></span>
				<strong>Info :</strong> ${info}</p>
			</div>
		</c:if>
	</body>
</html>
