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

    if(user.firstName && user.name) {
        if (user.newPassword) {
            if (user.confirmation) {
                if (user.newPassword == user.confirmation) {
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
                } else {
                    $('.error').text("The new password and the confirmation are not the same! Please type a new password and confirmation again.")
                }
            } else {
                $('.error').text("Please type the password confirmation.")
            }
        } else {
            $('.error').text("Please type a new password.")
        }
    }else {
        $('.error').text("Please type your firstname and your lastname.")
    }
};

NewAccount.prototype.getLastPage = function () {
    history.go(-1);
};
