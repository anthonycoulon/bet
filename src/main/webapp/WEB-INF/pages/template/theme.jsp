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
<div class="container">
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
			<span class="navbar-brand">Valtech Bet</span>
		</div>
        <div class="collapse navbar-collapse" id="menu-navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="menu-match" class="menu-item">
                    <a href="<c:url value="match"/>">Matches</a>
                </li>
                <li id="menu-ranking" class="menu-item">
                <a href="#">Ranking</a>
                </li>
                <li>
                    <a href="<c:url value="/j_spring_security_logout"/>">Sign out</a>
                </li>
            </ul>
         </div>
	</nav>
	<section id="content" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	<decorator:body/>
		</section>
	</section>
</div>
</body>
</html>
