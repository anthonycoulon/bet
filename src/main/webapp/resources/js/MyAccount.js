MyAccount = function() {
    this.contextUrl='/bet/myaccount/';
};

MyAccount.prototype.init = function() {
    $('#saveBtn').click(bind(this, this.saveUser));
    $('#cancelBtn').click(bind(this, this.getLastPage));
};

MyAccount.prototype.saveUser = function () {
    var user={};
    user.firstName = $("#firstName").val();
    user.name = $("#name").val();
    user.currentPassword = $("#currentPassword").val();
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();

    if(user.firstName && user.name && user.currentPassword && user.newPassword && user.confirmation && user.newPassword == user.confirmation) {
        this.ajax = new Ajax();
        this.ajax.postData(this.contextUrl + "update", user, bind(this, function () {
            this.ajax.success();
            $('.error').empty();
            $("#currentPassword").empty();
            $("#newPassword").empty();
            $("#confirmation").empty();
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
        if (hasAnError == false && !user.currentPassword) {
            $('.error').text("Please type your current password.");
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

MyAccount.prototype.getLastPage = function () {
    history.go(-1);
};
