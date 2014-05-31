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
};