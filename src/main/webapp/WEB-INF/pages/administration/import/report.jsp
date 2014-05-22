<%@page import="fr.socgen.sis.common.web.AbstractImportController"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<script type="text/javascript">
			$(function() {
				activateTab('tab_admin');
				activateMenu('menu_admin', 'menu_import_refs_${group}');
			});
		</script>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/import.css"/>" />
	</head>
	<body>
		<c:choose>
			<c:when test="${not empty asyncReport}">
				<c:choose>
			    	<c:when test="${asyncReport.systemActivityStatus == 'COMPLETED'}">
						<div class="ui-state-highlight ui-corner-all">
							${asyncReport.htmlContent}
						</div>
					</c:when>
			    	<c:otherwise>
						<div class="ui-state-error ui-corner-all report">
							${asyncReport.htmlContent}
						</div>
			    	</c:otherwise>
				</c:choose>
				<%session.removeAttribute(AbstractImportController.ASYNC_REPORT_SESSION_KEY); %>
			</c:when>
	    	<c:otherwise>
	    		Rafra&icirc;chissement  automatique toutes les 5 secondes jusqu'&agrave; l'affichage du rapport d'import. Veuillez patienter svp.
	    		<script type="text/JavaScript">
					setTimeout("location.reload(true);", 5000);
				</script>
	    	</c:otherwise>
	    </c:choose>
	</body>
</html>
