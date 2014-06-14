<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/MyAccount.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/myaccount.css"/>" />
    <script type="text/javascript">
        $(function() {
            $('.menu-item').removeClass('active');
            $('#menu-account').addClass('active');
        })
    </script>
</head>
<body>
<div class="container-fluid">
        <div class="control-group">
            <label class="control-label" for="firstName">Please type you Valtech email : </label>
            <div class="controls">
                <input type="text" class="form-control" id="firstName">
            </div>
        </div>
</div>
<script type="text/javascript">
    new MyAccount().init();
</script>
</body>
</html>
