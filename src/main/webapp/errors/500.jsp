<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" session="false" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Valtech Bet</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div id="container">
	<h1>500</h1>
	<h3>An internal error occurred on the server</h3>
	<p>Click <a href="mailto:anthony.coulon@valtech.fr">here</a> to contact the administrator.</p>
	<h3>Additional information</h3>
	<p><%=exception.getMessage()%></p>
	<!--
	<% exception.printStackTrace(new PrintWriter(out)); %>
	-->
</div>
</body>
</html>