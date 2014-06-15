ForgotPwd = function() {
    this.contextUrl='/bet/myaccount/forgotpwd/';
};


ForgotPwd.prototype.init = function() {
    $('#sendBtn').click(bind(this, this.resetPwd));
    $('#cancelBtn').click(bind(this, this.getLastPage));
    $('#closeModal').click(bind(this, this.getLastPage));
};

ForgotPwd.prototype.resetPwd = function () {
    this.initErrors();
    var email = $('#email').val();
    var emailChecker = new RegExp("[a-z\-]+\.[a-z\-]+@valtech\.(fr|de|uk|dk|se|com|us)");

    if(emailChecker.test(email)){
        this.ajax = new Ajax();
        this.ajax.get(this.contextUrl + "reset/" + email , bind(this, function () {
            $('.error').empty();
            $('#successModal').modal('show');
        }));
    }else{
        $('.error').text("Please check your email. (example: john.doe@valtech.fr)");
        $('#emailGroup').addClass("has-error");
    }

};

ForgotPwd.prototype.initErrors = function () {
    $('#emailGroup').removeClass("has-error");
};

ForgotPwd.prototype.getLastPage = function () {
    history.go(-1);
};