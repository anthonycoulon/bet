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
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();

    if(user.firstName && user.name && user.newPassword && user.confirmation && user.newPassword == user.confirmation) {
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
            hasAnError = true;
        }
        if (hasAnError == false && !user.name) {
            $('.error').text("Please type your lastname.");
            hasAnError = true;
        }
        if (hasAnError == false && !user.newPassword) {
            $('.error').text("Please type a new password.");
            hasAnError = true;
        }
        if (hasAnError == false && !user.confirmation) {
            $('.error').text("Please type the password confirmation.");
            hasAnError = true;
        }
        if (hasAnError == false && user.newPassword != user.confirmation) {
            $('.error').text("The new password and the confirmation are not the same! Please type a new password and confirmation again.");
            hasAnError = true;
        }
    }
};

NewAccount.prototype.getLastPage = function () {
    history.go(-1);
};
