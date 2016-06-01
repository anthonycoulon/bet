<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/ForgotPwd.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/myaccount.css"/>" />
    <script type="text/javascript">
        $(function() {
            $('.menu-item').removeClass('active');
            $('#menu-account').addClass('active');
        })
    </script>
</head>
<body>
<div class="modal fade" id="successModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">An email has been sent</h4>
            </div>
            <div class="modal-body">
                <p>An email has been sent with your new password.</p>
            </div>
            <div class="modal-footer">
                <button id="closeModal" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
        <div class="control-group" id="emailGroup">
            <label class="control-label" for="email">Please type your Valtech email : </label>
            <div class="controls">
                <input type="text" class="form-control" id="email" placeholder="Your Valtech Email">
                <span class="error"></span>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" id="sendBtn" class="btn btn-blue">Reset Password</button>
                    <button type="button" class="btn" id="cancelBtn">Cancel</button>
                </div>
            </div>
        </div>
</div>
<script type="text/javascript">
    new ForgotPwd().init();
</script>
</body>
</html>
