NewAccount = function() {
    this.contextUrl='/bet/myaccount/';
};
NewAccount.prototype.init = function() {
    $("#firstName").keyup(function(){
        $("#usernameF").val(this.value);
    });

    $("#name").keyup(function(){
        $("#usernameN").val(this.value);
    });

    $('#saveBtn').click(bind(this, this.saveUser));
};

NewAccount.prototype.saveUser = function () {

    var user={};

    user.id = $("#id").val();
    user.firstName = $("#firstName").val();
    user.name = $("#name").val();
    user.username = $("#username").val();
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();

    this.ajax = new Ajax();
    this.ajax.postData(this.contextUrl+"save", user, bind(this, function() {
        this.ajax.success();
        $("#newPassword").empty();
        $("#confirmation").empty();
    }));
};