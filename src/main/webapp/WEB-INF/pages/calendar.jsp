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
                <fmt:formatDate value="${match.timeDate}" pattern="hh:mm a"/>
            </th>
        </tr>
        <tr>
            <td>
				Group&nbsp;${match.matchLevel}
				<br/>
				${match.stadium.name}
            </td>
            <td class="opponent1">
	            ${match.opponent1.name}
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
                ${match.opponent2.name}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
