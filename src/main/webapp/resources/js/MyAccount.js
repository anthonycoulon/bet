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

    if(user.newPassword == user.confirmation){
        this.ajax = new Ajax();
        this.ajax.postData(this.contextUrl+"save", user, bind(this, function() {
            this.ajax.success();
            $('.error').empty();
            $("#currentPassword").empty();
            $("#newPassword").empty();
            $("#confirmation").empty();
        }));
    }else{
        $('.error').text("The new password and the confirmation are not the same! Please type a new password and confirmation again.")
    }

};

MyAccount.prototype.getLastPage = function () {
    history.go(-1);
};
