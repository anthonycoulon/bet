Ajax = function() {};

Ajax.prototype.get = function(_url, _handler) {
	$.ajax({
		beforeSend: bind(this, this.createSpinner),
		complete: bind(this, this.removeSpinner),
		url : _url,
		cache : false,
		type : 'GET',
		success : _handler ? _handler : function(){/*TODO something*/},
		error : bind(this, this.error)
	});
};

Ajax.prototype.postData = function(_url, _data, _handler) {
	$.ajax({
		beforeSend: bind(this, this.createSpinner),
		complete: bind(this, this.removeSpinner),
		url : _url,
		cache : false,
		type : 'POST',
		data: JSON.stringify(_data),
		datatype : 'json',
		contentType : 'application/json',
		success: _handler ? _handler : function(){/*TODO something*/},
		error: bind(this, this.error)
	});
};

Ajax.prototype.post = function(_url, _handler) {
	$.ajax({
		beforeSend: bind(this, this.createSpinner),
		complete: bind(this, this.removeSpinner),
		url : _url,
		cache : false,
		type : 'POST',
		success: _handler ? _handler : function(){/*TODO something*/},
		error: bind(this, this.error)
	});
};

Ajax.prototype.del = function(_url) {
	$.ajax({
		beforeSend: bind(this, this.createSpinner),
		complete: bind(this, this.removeSpinner),
		url : _url,
		cache : false,
		type : 'DELETE'
	});
};

Ajax.prototype.delAction = function(_url, _handler) {
	$.ajax({
		beforeSend: bind(this, this.createSpinner),
		complete: bind(this, this.removeSpinner),
		url : _url,
		cache : false,
		type : 'DELETE',
		success: _handler ? _handler : function(){/*TODO something*/},
		error: bind(this, this.error)
	});
};

Ajax.prototype.error = function(jqXHR) {
	//TODO something
};

Ajax.prototype.createSpinner = function() {
	this.spinner = new Spinner();
	this.icon_waiting = $('<div class="waiting"></div>');
	$('.blue').append(this.icon_waiting);
	this.spinner.spin(); 
	$(this.icon_waiting).append(this.spinner.el);
};

Ajax.prototype.removeSpinner = function() {
	this.spinner.stop(); 
	this.icon_waiting.remove();
};
