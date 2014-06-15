NewAccount = function() {
    this.contextUrl='/bet/myaccount/';
};

NewAccount.prototype.init = function() {
    $("#firstName").keyup(function(){
        $("#usernameF").val(this.value.toLowerCase());
    });

    $("#name").keyup(function(){
        $("#usernameN").val(this.value.toLowerCase());
    });

    $('#saveBtn').click(bind(this, this.saveUser));
    $('#cancelBtn').click(bind(this, this.getLastPage));
};

NewAccount.prototype.saveUser = function () {

    var user={};

    user.id = $("#id").val();
    user.firstName = $("#firstName").val();
    user.name = $("#name").val();
    user.username = $("#username").val();
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();

    var emailChecker = new RegExp("[a-z\-]+\.[a-z\-]+@valtech\.(fr|de|uk|dk|se|com|us)");
    var isEmailGood = emailChecker.test(user.username);
    user.isEmailGood = isEmailGood;

    this.initErrors();
    if(user.firstName && user.name && user.newPassword && user.confirmation && user.newPassword == user.confirmation && isEmailGood) {
        this.ajax = new Ajax();
        this.ajax.postData(this.contextUrl + "save", user, bind(this, function () {
            this.ajax.success();
            $('.error').empty();
            $("#newPassword").empty();
            $("#confirmation").empty();
            setTimeout(function () {
                window.location = '/bet/login';
            }, 2000);
        }));
    }else {
        var hasAnError = false;
        if (!user.firstName) {
            $('.error').text("Please type your firstname.");
            $('#firstNameGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !user.name) {
            $('.error').text("Please type your lastname.");
            $('#nameGroup').addClass("has-error");
            hasAnError = true;
        }
        if(hasAnError == false && !isEmailGood){
            $('.error').text("Please check your email. (example: john.doe@valtech.fr)");
            $('#usernameGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !user.newPassword) {
            $('.error').text("Please type a new password.");
            $('#newPasswordGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !user.confirmation) {
            $('.error').text("Please type the password confirmation.");
            $('#confirmationGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && user.newPassword != user.confirmation) {
            $('.error').text("The new password and the confirmation are not the same! Please type a new password and confirmation again.");
            $('#newPasswordGroup').addClass("has-error");
            $('#confirmationGroup').addClass("has-error");
        }
    }
};

NewAccount.prototype.initErrors = function () {
    $('#firstNameGroup').removeClass("has-error");
    $('#nameGroup').removeClass("has-error");
    $('#usernameGroup').removeClass("has-error");
    $('#newPasswordGroup').removeClass("has-error");
    $('#confirmationGroup').removeClass("has-error");
};

NewAccount.prototype.getLastPage = function () {
    history.go(-1);
};
