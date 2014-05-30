MyAccount = function() {
    this.contextUrl='/bet/myaccount/';
};
MyAccount.prototype.init = function() {
    $('#saveBtn').click(bind(this, this.saveUser));
};

MyAccount.prototype.saveUser = function () {

    var user={};
    user.id = $("#id").val();
    user.firstname = $("#firstname");
    user.name = $("#name");
    user.username = $("#username").val();
    user.currentPassword = $("#currentPassword").val();
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();

    this.ajax = new Ajax();
    this.ajax.postData(this.contextUrl+"save", user, bind(this, function(_data) {
        this.ajax.success();
        $("#currentPassword").empty();
        $("#newPassword").empty();
        $("#confirmation").empty();
    }));
};
