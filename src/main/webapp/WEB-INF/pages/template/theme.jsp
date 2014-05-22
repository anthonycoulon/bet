<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <title>Valtech Bet</title>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bet.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" />

	<script type="text/javascript" src="<c:url value="/resources/js/Ajax.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/Bind.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/Inherit.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/spin.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

	<decorator:head />

</head>

<body>
	<decorator:body />
</body>
</html>
