MyAccount = function() {
    this.contextUrl='/bet/myaccount/';
};

MyAccount.prototype.init = function() {

	$('input[type=file]').bootstrapFileInput();

    $('#saveBtn').click(bind(this, this.saveUser));
    $('#cancelBtn').click(bind(this, this.getLastPage));
    $('#changePwd').click(bind(this, this.showPwd));

	$('#uploadAvatar').click(bind(this, this.postAvatar));
};

MyAccount.prototype.saveUser = function () {
    var user={};
    user.firstName = $("#firstName").val();
    user.name = $("#name").val();
    user.currentPassword = $("#currentPassword").val();
    user.newPassword = $("#newPassword").val();
    user.confirmation = $("#confirmation").val();
    user.modifyPwd = $("#changePwd").is(":checked");

    this.initErrors();
    if(user.modifyPwd) {
        bind(this, this.modfifyUserWithNewPassword(user));
    }else{
        bind((this, this.modfifyUserWithoutNewPassword(user)));
    }
};

MyAccount.prototype.showPwd = function () {

    if($("#changePwd").is(":checked")){
        $(".showPwd").removeAttr("hidden");
    }else{
        $(".showPwd").attr("hidden", "hidden");
    }
};

MyAccount.prototype.postAvatar = function () {
	if ($('input[type=file]').prop("files").length != 0) {
		var formData = new FormData();
		formData.append("file", $('input[type=file]').prop("files")[0]);

		$.ajax({
			url: this.contextUrl + "avatar",
			type: 'POST',
			data: formData,
			dataType: 'text',
			contentType: false,
			cache: false,
			processData: false,
			success: function (_data) {
				$('#avatar-result').html(_data)
			},
			error: function () {
				$('#avatar-result').html('<div class="error">An error occurred. Please try again or change image (max 150 ko).</div>')
			}
		});
	}
};

MyAccount.prototype.modfifyUserWithoutNewPassword = function (_user) {
    if (_user.firstName && _user.name && _user.currentPassword) {
        this.ajax = new Ajax();
        this.ajax.postData(this.contextUrl + "update", _user, bind(this, function () {
            this.ajax.success();
            $('.error').empty();
            $("#currentPassword").empty();
            $("#newPassword").empty();
            $("#confirmation").empty();
        }));
    } else {
        var hasAnError = false;
        if (!_user.firstName) {
            $('.error').text("Please type your firstname.");
            $('#firstNameGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !_user.name) {
            $('.error').text("Please type your lastname.");
            $('#nameGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !_user.currentPassword) {
            $('.error').text("Please type your current password.");
            $('#currentPasswordGroup').addClass("has-error");
        }
    }
};

MyAccount.prototype.modfifyUserWithNewPassword = function (_user) {

    if (_user.firstName && _user.name && _user.currentPassword && _user.newPassword && _user.confirmation && _user.newPassword == _user.confirmation) {
        this.ajax = new Ajax();
        this.ajax.postData(this.contextUrl + "update", _user, bind(this, function () {
            this.ajax.success();
            $('.error').empty();
            $("#currentPassword").empty();
            $("#newPassword").empty();
            $("#confirmation").empty();
        }));
    } else {
        var hasAnError = false;
        if (!_user.firstName) {
            $('.error').text("Please type your firstname.");
            $('#firstNameGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !_user.name) {
            $('.error').text("Please type your lastname.");
            $('#nameGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !_user.currentPassword) {
            $('.error').text("Please type your current password.");
            $('#currentPasswordGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !_user.newPassword) {
            $('.error').text("Please type a new password.");
            $('#newPasswordGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && !_user.confirmation) {
            $('.error').text("Please type the password confirmation.");
            $('#confirmationGroup').addClass("has-error");
            hasAnError = true;
        }
        if (hasAnError == false && _user.newPassword != _user.confirmation) {
            $('.error').text("The new password and the confirmation are not the same! Please type a new password and confirmation again.");
            $('#newPasswordGroup').addClass("has-error");
            $('#confirmationGroup').addClass("has-error");
        }
    }
};

MyAccount.prototype.initErrors = function () {
    $('#firstNameGroup').removeClass("has-error");
    $('#nameGroup').removeClass("has-error");
    $('#currentPasswordGroup').removeClass("has-error");
    $('#newPasswordGroup').removeClass("has-error");
    $('#confirmationGroup').removeClass("has-error");
};

MyAccount.prototype.getLastPage = function () {
    history.go(-1);
};
