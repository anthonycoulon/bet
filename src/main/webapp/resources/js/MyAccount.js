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

    if(user.firstName && user.name) {
        if (user.currentPassword) {
            if (user.newPassword) {
                if (user.confirmation) {
                    if (user.newPassword == user.confirmation) {
                        this.ajax = new Ajax();
                        this.ajax.postData(this.contextUrl + "update", user, bind(this, function () {
                            this.ajax.success();
                            $('.error').empty();
                            $("#currentPassword").empty();
                            $("#newPassword").empty();
                            $("#confirmation").empty();
                        }));
                    } else {
                        $('.error').text("The new password and the confirmation are not the same! Please type a new password and confirmation again.")
                    }
                } else {
                    $('.error').text("Please type the password confirmation.")
                }
            } else {
                $('.error').text("Please type a new password.")
            }
        } else {
            $('.error').text("Please type your current password.")
        }
    }else {
        $('.error').text("Please type your firstname and your lastname.")
    }
};

MyAccount.prototype.getLastPage = function () {
    history.go(-1);
};
