<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Portail iSIS</title>       
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/errors.css"/>" />  
</head>
<body>
<div id="container">
	<div id="message">
		<h1>La page demand&eacute;e n'a pas &eacute;t&eacute; trouv&eacute;e.</h1>
		<p>Cliquez <a href="/sis-portal/">ici</a> pour retourner sur le portail </p>
	</div>
	<img id="error" src="<c:url value='/resources/img/errors/404.png' />">
</div>
</body>
</html>