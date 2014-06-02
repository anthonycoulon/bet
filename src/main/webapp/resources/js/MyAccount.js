MyAccount = function() {
    this.contextUrl='/bet/myaccount/';
};
MyAccount.prototype.init = function() {
    $('#saveBtn').click(bind(this, this.saveUser));
};

MyAccount.prototype.saveUser = function () {

    var user={};

    user.id = $("#id").val();
    user.firstName = $("#firstName").val();
    user.name = $("#name").val();
    user.username = $("#username").val();
    user.currentPassword = $("#currentPassword").val();
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();

    this.ajax = new Ajax();
    this.ajax.postData(this.contextUrl+"save", user, bind(this, function() {
        this.ajax.success();
        $("#currentPassword").empty();
        $("#newPassword").empty();
        $("#confirmation").empty();
    }));
};
