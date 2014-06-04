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
            <th colspan="4">
                <fmt:formatDate value="${match.matchDate}"
            <th>
                <fmt:formatDate value="${match[2]}"
                                pattern="dd/MM/yyyy"/>
                <fmt:formatDate value="${match.timeDate}"
                                pattern="hh:mm a"/>
            </th>
        </tr>
        <tr>
            <td>
                   Group &nbsp; ${match[0].group}
                   <br/>
                    ${match[4].name}
            </td>
            <td style="text-align: right;">
	            ${match.opponent1.name}&nbsp;<span class="famfamfam-flag-<c:out value="${match.opponent1.flag}"/>"></span>
            <td>
	            <span class="famfamfam-flag-<c:out value="${match[0].flag}"/>"></span> &nbsp;${match[0].name}
            </td>
            <td style="text-align: center;">
	            <c:choose>
		            <c:when test="${empty match.score}">
			            -
		            </c:when>
		            <c:otherwise>
			            ${match.score}
		            </c:otherwise>
	            </c:choose>

            <td>
                <fmt:formatDate value="${match[3]}"
                                pattern="hh:mm a"/>
            </td>
            <td>
                <span class="famfamfam-flag-<c:out value="${match.opponent2.flag}"/>"></span>&nbsp;${match.opponent2.name}
                <span class="famfamfam-flag-<c:out value="${match[1].flag}"/>"></span> &nbsp;${match[1].name}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
