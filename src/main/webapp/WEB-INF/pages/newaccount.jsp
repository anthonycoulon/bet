<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/NewAccount.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/myaccount.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/newaccount.css"/>" />
    <script type="text/javascript">
        $(function() {
            $('.menu-item').removeClass('active');
            $('#menu-account').addClass('active');
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <form class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="firstName">First Name</label>
            <div class="controls">
                <input type="text" id="firstName" placeholder="First Name" class="form-control">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="name">Last Name</label>
            <div class="controls">
                <input type="text" id="name" placeholder="Last Name" class="form-control">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">Email</label>
            <div class="controls">
                <input type="text" id="usernameF" disabled class="form-control">.
                <input type="text" id="usernameN" disabled class="form-control">@valtech.fr
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="newPassword">New Password</label>
            <div class="controls">
                <input type="password" id="newPassword" placeholder="New Password" class="form-control">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="confirmation">Confirmation</label>
            <div class="controls">
                <input type="password" id="confirmation" placeholder="Confirmation" class="form-control">
            </div>
        </div>
        <span class="error"></span>
    </form>
    <div class="control-group">
        <div class="controls">
            <button type="submit" id="saveBtn" class="btn btn-primary">Save changes</button>
            <button type="button" class="btn" id="cancelBtn">Cancel</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    new NewAccount().init();
</script>
</body>
</html>
