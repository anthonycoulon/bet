<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Valtech Bet</title>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico"/>"/>

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
			<span class="navbar-brand"><a href="/">Valtech Bet</a></span>
		</div>
        <div class="collapse navbar-collapse" id="menu-navbar-collapse">
	        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
		        <ul class="nav navbar-nav">
		            <li id="menu-match" class="menu-item">
		                <a href="<c:url value="match"/>">Matches</a>
		            </li>
		            <li id="menu-ranking" class="menu-item">
		                <a href="<c:url value="ranking"/>">Ranking</a>
		            </li>
		            <li id="menu-rules" class="menu-item">
		                <a href=<c:url value="/rules"/>>Rules</a>
		            </li>
		            <li id="menu-account" class="menu-item">
		                <a href=<c:url value="/myaccount"/>>My account</a>
		            </li>
			        <sec:authorize access="hasRole('ROLE_ADMIN')">
			            <li id="menu-admin" class="menu-item">
			                <a href=<c:url value="/admin"/>>Administration</a>
			            </li>
			        </sec:authorize>
		            <li>
		                <a href="<c:url value="/j_spring_security_logout"/>">Sign out</a>
		            </li>
		        </ul>
	        </sec:authorize>
            <ul class="nav navbar-nav">
                <li id="menu-match" class="menu-item">
                    <a href="<c:url value="match"/>">Matches</a>
                </li>
                <li id="menu-ranking" class="menu-item">
                    <a href="<c:url value="ranking"/>">Ranking</a>
                </li>
                <li class="dropdown menu-item"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Calendar<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="menu-item">
                            <ul class="list-inline">
                                <li><a href="calendar?level=A">Group A</a></li>
                                <li><a href="calendar?level=B">Group B</a></li>
                                <li><a href="calendar?level=C">Group C</a></li>
                                <li><a href="calendar?level=D">Group D</a></li>
                                <li><a href="calendar?level=E">Group E</a></li>
                                <li><a href="calendar?level=F">Group F</a></li>
                                <li><a href="calendar?level=G">Group G</a></li>
                                <li><a href="calendar?level=H">Group H</a></li>
                            </ul>
                        </li>
                        <li class="divider"></li>
                        <li><a href="calendar?level=EF">Eighth Final</a></li>
                        <li class="divider"></li>
                        <li><a href="calendar?level=QF">Quarter Final</a></li>
                        <li class="divider"></li>
                        <li><a href="calendar?level=SF">Semi Final</a></li>
                        <li class="divider"></li>
                        <li><a href="calendar?level=TP">Third Place</a></li>
                        <li class="divider"></li>
                        <li><a href="calendar?level=Final">Final</a></li>
                    </ul>
                </li>
                <li id="menu-account" class="menu-item">
                    <a href=<c:url value="/myaccount"/>>My account</a>
                </li>
                <li>
                    <a href="<c:url value="/j_spring_security_logout"/>">Sign out</a>
                </li>
            </ul>
         </div>
	</nav>
		<div class="alert alert-success bet-alert">Successfully saved</div>
		<div class="alert alert-danger bet-alert">Error server ...</div>
	<section id="content" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<decorator:body/>
	</section>
</div>
</body>
</html>
