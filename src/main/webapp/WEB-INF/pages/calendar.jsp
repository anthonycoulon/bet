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
            <th>
                <fmt:formatDate value="${match.matchDate}"
                                pattern="dd/MM/yyyy"/>
            </th>
            <th> </th>
            <th> </th>
            <th> </th>
        </tr>
        <tr>
            <td>
                   Group &nbsp; ${match.opponent1.group}
                   <br/>
                    ${match.stadium.name}
            </td>
            <td>
	            <span class="famfamfam-flag-<c:out value="${match.opponent1.flag}"/>"></span> &nbsp;${match.opponent1.name}
            </td>
            <td>
                <fmt:formatDate value="${match.timeDate}"
                                pattern="hh:mm a"/>
            </td>
            <td>
                <span class="famfamfam-flag-<c:out value="${match.opponent2.flag}"/>"></span> &nbsp;${match.opponent2.name}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
