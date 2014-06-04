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
	for (var i = 0; i < matches.length; i+=2) {
		var matchTime=$(matches[i]).find('td input.matchTime').val();
		if(matchTime<=today.getTime()) {
			$(matches[i]).next().find('td input.bet').attr('disabled','disabled')
		}
	}
	if(matches.length==$('input.bet[disabled=disabled]').length/2) {
		$('#save_button').attr('disabled', 'disabled');
	}else {
		$('#save_button').removeAttr('disabled');
	}
};

Matches.prototype.checkBetValue = function (bet1, bet2) {
	if ((bet2.val().match(/[0-9]+/g) && bet1.val().match(/[0-9]+/g)) || (bet2.val()=='' && bet1.val()=='')) {
		bet1.parent().removeClass('has-error');
	} else {
		bet1.parent().addClass('has-error');
	}
};

Matches.prototype.saveBet = function() {
	var matches = $('#matches tbody tr');
	var bets=[];
	for(var i=0; i<matches.length; i+=2){
		var m = matches[i];
		var bet={};
		bet.betId = $(m).find('.betId').val();
		bet.matchId = $(m).find('.matchId').val();
		this.checkBetValue($(m).next().find('.bet1'), $(m).next().find('.bet2'));
		bet.bet1 = $(m).next().find('.bet1').val();
		bet.bet2 = $(m).next().find('.bet2').val();
		bet.matchTime = $(m).find('.matchTime').val();
		bets.push(bet);
	}

	this.ajax = new Ajax();
	this.ajax.postData(this.contextUrl, bets, bind(this, function(_data) {
		this.ajax.success();
		for(var i=0; i<_data.length; i++) {
			var q = _data[i];
			var progress = $('tr input.matchId[type=hidden][value='+ q.matchId+']').parent().parent().next().find('td div.progress');
			progress.empty();
			progress.append(Matches.maskOdds
				.replace('${dto.odds1}', q.odds1)
				.replace('${dto.odds1}', q.odds1)
				.replace('${dto.odds1}', q.odds1)
				.replace('${dto.odds2}', q.odds2)
				.replace('${dto.odds2}', q.odds2)
				.replace('${dto.odds2}', q.odds2)
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
		if(_data.length==0) {
			$('#no-match').show();
		}else {
			$('#no-match').hide();
		}
		for(var i=0; i<_data.length; i++) {
			var d = _data[i];
			var time = this.extracteTime(d.matchTime);
			var match = Matches.mask.replace('${dto.opponent1}', d.opponent1)
				.replace('${dto.flag1}', d.flag1)
				.replace('${dto.matchTime}', time)
				.replace('${dto.matchLevel}', d.matchLevel)
				.replace('${dto.matchTime.time}', d.matchTime)
				.replace('${dto.betId}', d.betId ? d.betId : '')
				.replace('${dto.matchId}', d.matchId)
				.replace('${dto.score}', d.score ? '<b>' + d.score + '</b>' : '-')
				.replace('${dto.bet1}', d.bet1==null ? '' : d.bet1)
				.replace('${dto.bet2}', d.bet2==null ? '' : d.bet2)
				.replace('${dto.opponent2}', d.opponent2)
				.replace('${dto.flag2}', d.flag2)
				.replace('${dto.odds1}', d.odds1)
				.replace('${dto.odds1}', d.odds1)
				.replace('${dto.odds1}', d.odds1)
				.replace('${dto.odds2}', d.odds2)
				.replace('${dto.odds2}', d.odds2)
				.replace('${dto.odds2}', d.odds2);
			$('table#matches tbody').append(match);
		}
		this.disabledBet();
	}));
};

Matches.mask=
'<tr>'+
	'<td style="display: none">'+
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
	'<td class="opponent1">'+
		'${dto.opponent1}'+
	'</td>'+
	'<td class="flagM">'+
		'<span class="famfamfam-flag-${dto.flag1}"></span>'+
	'</td>'+
	'<td class="score">'+
		'${dto.score}'+
	'</td>'+
	'<td class="flagM">'+
		'<span class="famfamfam-flag-${dto.flag2}"></span>'+
	'</td>'+
	'<td class="opponent2">'+
		'${dto.opponent2}'+
	'</td>'+
'</tr>' +
'<tr>' +
	'<td>'+
		'<b>Bet : </b>'+
	'</td>'+
	'<td colspan="2" class="bet">'+
		'<input type="text" class="bet1 bet form-control" value="${dto.bet1}"/> - <input type="text" class="bet2 bet form-control" value="${dto.bet2}"/>'+
	'</td>'+
	'<td colspan="4">' +
		'<div class="progress">'+
			'<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${dto.odds1}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.odds1}%;">'+
				'${dto.odds1}%'+
			'</div>'+
			'<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${dto.odds2}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.odds2}%;">'+
				'${dto.odds2}%'+
			'</div>'+
		'</div>'+
	'</td>'+
'</tr>';

Matches.maskOdds=
'<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${dto.odds1}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.odds1}%;">'+
	'${dto.odds1}%'+
'</div>'+
'<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${dto.odds2}" aria-valuemin="0" aria-valuemax="100" style="width: ${dto.odds2}%;">'+
	'${dto.odds2}%'+
'</div>';