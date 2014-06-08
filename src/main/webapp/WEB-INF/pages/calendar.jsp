<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/flags.css"/>"/>
	<script type="text/javascript">
		$(function() {
			$('.menu-item').removeClass('active');
			$('#menu-calendar').addClass('active');
		})
	</script>
</head>
<body>
<table id="matches" class="table-responsive table table-condensed">

    <tbody>
    <c:forEach items="${matches}" var="match">
        <tr>
            <th colspan="6">
                <fmt:formatDate value="${match.matchDate}" pattern="dd/MM/yyyy"/>
                <fmt:formatDate value="${match.timeDate}" pattern="KK:mm a"/>
            </th>
        </tr>
        <tr>
            <td>
				${match.matchLevel.label}
				<br/>
				${match.stadium.name}
            </td>
            <td class="opponent1">
	            <c:choose>
		            <c:when test="${match.winner==1}">
			            <b>${match.opponent1.name}</b>
		            </c:when>
		            <c:otherwise>
			            ${match.opponent1.name}
		            </c:otherwise>
	            </c:choose>
            </td>
	        <td class="flag">
		        <span class="famfamfam-flag-${match.opponent1.flag}"></span>
	        </td>
            <td class="score">
	            <c:choose>
		            <c:when test="${empty match.score}">
			            -
		            </c:when>
		            <c:otherwise>
			            <b>${match.score}</b>
		            </c:otherwise>
	            </c:choose>
            </td>
	        <td  class="flag">
		        <span class="famfamfam-flag-${match.opponent2.flag}"></span>
	        </td>
            <td class="opponent2">
	            <c:choose>
		            <c:when test="${match.winner==2}">
			            <b>${match.opponent2.name}</b>
		            </c:when>
		            <c:otherwise>
			            ${match.opponent2.name}
		            </c:otherwise>
	            </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
