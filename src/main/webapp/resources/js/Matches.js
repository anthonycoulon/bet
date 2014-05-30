Matches = function() {
	this.contextUrl='/bet/match/';
};

Matches.prototype.init = function() {

	this.disabledBet();
	$('#dates').change(bind(this, this.refreshMatches));
	$('#save_button').click(bind(this, this.saveBet));
};

Matches.prototype.disabledBet = function () {
	var matches = $('#matches tbody tr');
	var today = new Date();
	for (var i = 0; i < matches.length; i++) {
		var matchTime=$(matches[i]).find('td input.matchTime').val();
		if(matchTime<=today.getTime()) {
			$(matches[i]).find('td input.bet').attr('disabled','disabled')
		}
	}
	if(matches.length==$('input.bet[disabled=disabled]').length/2) {
		$('#save_button').attr('disabled', 'disabled');
	}else {
		$('#save_button').removeAttr('disabled');
	}
};

Matches.prototype.saveBet = function() {
	var matches = $('#matches tbody tr');
	var bets=[];
	for(var i=0; i<matches.length; i++){
		var m = matches[i];
		var bet={};
		bet.betId = $(m).find('.betId').val();
		bet.matchId = $(m).find('.matchId').val();
		bet.bet1 = $(m).find('.bet1').val();
		bet.bet2 = $(m).find('.bet2').val();
		bet.matchTime = $(m).find('.matchTime').val();
		bets.push(bet);
	}

	this.ajax = new Ajax();
	this.ajax.postData(this.contextUrl, bets, bind(this, function(_data) {
		this.ajax.success();
		for(var i=0; i<_data.length; i++) {
			console.log(_data);
			var q = _data[i];
			var progress = $('tr input[type=hidden][value='+ q.matchId+']').parent().parent().find('td div.progress');
			progress.empty();
			progress.append(Matches.maskQuote
				.replace('${dto.quote1}', q.quote1)
				.replace('${dto.quote1}', q.quote1)
				.replace('${dto.quote1}', q.quote1)
				.replace('${dto.quote2}', q.quote2)
				.replace('${dto.quote2}', q.quote2)
				.replace('${dto.quote2}', q.quote2)
			);
		}
	}));
};

Matches.prototype.extracteTime = function (timestamp) {
	if(!timestamp) {
		return '';
	}
	var matchTime = new Date(timestamp);
	var hours = matchTime.getHours()>12 ? matchTime.getHours()-12 : matchTime.getHours();
	hours = hours<10 ? '0'+hours : hours;
	var minutes = matchTime.getMinutes()>10 ? matchTime.getMinutes() : '0'+matchTime.getMinutes();
	var a = matchTime.getHours()>12 ? 'PM' : 'AM';
	var time = hours + ':' + minutes+' '+a;
	return time;
};

Matches.prototype.refreshMatches = function() {
	$('table#matches tbody').empty();
	new Ajax().get(this.contextUrl+$('#dates').val(), bind(this,function(_data){
		for(var i=0; i<_data.length; i++) {
			var d = _data[i];
			var time = this.extracteTime(d.matchTime);
			var match = Matches.mask.replace('${dto.opponent1}', d.opponent1)
				.replace('${dto.matchTime}', time)
				.replace('${dto.matchLevel}', d.matchLevel)
				.replace('${dto.matchTime.time}', d.matchTime)
				.replace('${dto.betId}', d.betId == null ? '' : d.betId)
				.replace('${dto.matchId}', d.matchId)
				.replace('${dto.score}', d.score == null ? '' : d.score)
				.replace('${dto.bet1}', d.bet1 == null ? '' : d.bet1)
				.replace('${dto.bet2}', d.bet2 == null ? '' : d.bet2)
				.replace('${dto.opponent2}', d.opponent2)
				.replace('${dto.quote1}', d.quote1)
				.replace('${dto.quote1}', d.quote1)
				.replace('${dto.quote1}', d.quote1)
				.replace('${dto.quote2}', d.quote2)
				.replace('${dto.quote2}', d.quote2)
				.replace('${dto.quote2}', d.quote2);
			$('table#matches tbody').append(match);
		}
		this.disabledBet();
	}));
};

Matches.mask=
'<tr>'+
	'<td>'+
		'<input class="betId" type="hidden" value="${dto.betId}"/>'+
		'<input class="matchId" type="hidden" value="${dto.matchId}"/>'+
	'</td>'+
	'<td>'+
		'${dto.matchLevel}'+
	'</td>'+
	'<td>' +
		'<input type="hidden" value="${dto.matchTime.time}" class="matchTime"/>' +
		'${dto.matchTime}' +
	'</td>'+
	'<td>'+
		'${dto.opponent1}'+
	'</td>'+
	'<td>'+
		'${dto.score}'+
	'</td>'+
	'<td class="bet">'+
		'<input type="text" class="bet1 bet" value="${dto.bet1}"/> - <input type="text" class="bet2 bet" value="${dto.bet2}"/>'+
	'</td>'+
	'<td>'+
		'${dto.opponent2}'+
	'</td>'+
	'<td>' +
		'<div class="progress">'+
			'<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${dto.quote1}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.quote1}%;">'+
				'${dto.quote1}%'+
			'</div>'+
			'<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${dto.quote2}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.quote2}%;">'+
				'${dto.quote2}%'+
			'</div>'+
		'</div>'+
	'</td>'+
'</tr>';

Matches.maskQuote=
'<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${dto.quote1}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.quote1}%;">'+
	'${dto.quote1}%'+
'</div>'+
'<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${dto.quote2}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.quote2}%;">'+
	'${dto.quote2}%'+
'</div>';