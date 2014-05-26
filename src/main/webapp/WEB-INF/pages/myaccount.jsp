<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/myaccount.css"/>" />
</head>
<body>
<div class="container-fluid">
    <form class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="firstName">First Name</label>
            <div class="controls">
                <input type="text" id="firstName" value="${user.firstName}">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="name">Last Name</label>
            <div class="controls">
                <input type="text" id="name" value="${user.name}">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="username">Email</label>
            <div class="controls">
                <input type="text" id="username" value="${user.username}" disabled>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="currentPassword">Current Password</label>
            <div class="controls">
                <input type="password" id="currentPassword" placeholder="Current Password">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="newPassword">New Password</label>
            <div class="controls">
                <input type="password" id="newPassword" placeholder="New Password">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="confirmation">Confirmation</label>
            <div class="controls">
                <input type="password" id="confirmation" placeholder="Confirmation">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button id="saveBtn" type="submit" class="btn btn-large btn-primary">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
