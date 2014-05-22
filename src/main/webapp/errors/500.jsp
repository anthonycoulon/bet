<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" session="false" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Portail iSIS</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/errors.css"/>" />
</head>
<body>
<div id="container">
	<div id="message">
		<h1>Une erreur interne s'est produite au niveau du serveur que vous essayez de contacter.</h1>
		<p>Cliquez <a href="mailto:List.Par-Support-Isis@socgen.com">ici</a> pour prendre contact avec l'administrateur </p>
		<h3>Information compl&eacute;mentaire</h3>
		<p><%=exception.getMessage()%></p>
		<!--
		<% exception.printStackTrace(new PrintWriter(out)); %>
		-->
	</div>
	<img id="error" src="<c:url value='/resources/img/errors/500.png' />">
</div>
</body>
</html>