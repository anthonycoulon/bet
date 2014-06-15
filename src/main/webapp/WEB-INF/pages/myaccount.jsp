<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/MyAccount.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.file-input.js"/>"></script>
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
    <form class="form-horizontal">
        <div class="control-group" id="firstNameGroup">
            <label class="control-label" for="firstName">First Name</label>
            <div class="controls">
                <input type="text" class="form-control" id="firstName" value="${user.firstName}">
            </div>
        </div>
        <div class="control-group" id="nameGroup">
            <label class="control-label" for="name">Last Name</label>
            <div class="controls">
                <input type="text" class="form-control" id="name" value="${user.name}">
            </div>
        </div>
        <div class="control-group" id="usernameGroup">
            <label class="control-label" for="username">Your Valtech Email</label>
            <div class="controls">
                <input type="text" class="form-control" id="username" value="${user.username}" disabled>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="avatar">Avatar :</label>
            <div class="controls">
                <input type="file" class="btn btn-primary" id="avatar" value="">
	            <section id="avatar-result"><img src="/bet/myaccount/download/avatar" alt="avatar" class="img-responsive avatar"/></section>
            </div>
        </div>
        <div class="control-group" id="currentPasswordGroup">
            <label class="control-label" for="currentPassword">Current Password</label>
            <div class="controls">
                <input type="password" class="form-control" id="currentPassword" placeholder="Current Password">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="checkbox" class="" id="changePwd"><label id="changePwdLabel" for="changePwd">Change Password</label>
            </div>
        </div>
        <div class="control-group showPwd" id="newPasswordGroup" hidden="hidden">
            <label class="control-label" for="newPassword">New Password</label>
            <div class="controls">
                <input type="password" class="form-control" id="newPassword" placeholder="New Password">
            </div>
        </div>
        <div class="control-group showPwd" id="confirmationGroup" hidden="hidden">
            <label class="control-label" for="confirmation">Confirmation</label>
            <div class="controls">
                <input type="password" class="form-control" id="confirmation" placeholder="Confirmation">
            </div>
        </div>
        <span class="error"></span>
    </form>
    <div class="form-actions">
        <div class="controls">
            <button type="submit" id="saveBtn" class="btn btn-primary">Save changes</button>
            <button type="button" class="btn" id="cancelBtn">Cancel</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    new MyAccount().init();
</script>
</body>
</html>
