Admin = function() {
	this.contextUrl='/bet/admin/';
};

Admin.prototype.init = function() {
	$('#run-button').click(function(){
		window.location='/bet/admin/calculateTask'
	});

	$('#save-button').click(bind(this, this.saveMatch));
};

Admin.prototype.saveMatch = function() {
	var datas=[];
	var lines = $('table#matches tbody tr');
	for(var i=0; i<lines.length; i++) {
		var line = lines[i];
		var data={};
		data.id=$(line).find('td input#id').val();
		data.score=$(line).find('td input#score').val();
		datas.push(data);
	}

	new Ajax().postData(this.contextUrl, datas);
};

