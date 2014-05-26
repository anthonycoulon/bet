Matches = function() {
	this.contextUrl='/bet/match/';
};

Matches.prototype.init = function() {
	$('#dates').change(bind(this, this.refreshMatches));
	$('#save_button').click(bind(this, this.saveBet));
};

Matches.prototype.saveBet = function() {
	var matches = $('#matches section.row');
	var bets=[];
	for(var i=0; i<matches.length; i++){
		var m = matches[i];
		var bet={};
		bet.betId = $(m).find('.betId').val();
		bet.matchId = $(m).find('.matchId').val();
		bet.bet1 = $(m).find('.bet1').val();
		bet.bet2 = $(m).find('.bet2').val();
		bets.push(bet);
	}

	new Ajax().postData(this.contextUrl, bets, function() {
		alert('ok');
	})
};

Matches.prototype.refreshMatches = function() {
	$('#matches').empty();
	new Ajax().get(this.contextUrl+$('#dates').val(), function(_data){
		for(var i=0; i<_data.length; i++) {
			var d=_data[i];
			var match = Matches.mask.replace('${dto.opponent1}', d.opponent1)
				.replace('${dto.betId}', d.betId)
				.replace('${dto.matchId}', d.matchId)
				.replace('${dto.score}', d.score==null?'':d.score)
				.replace('${dto.bet1}', d.bet1==null?'': d.bet1)
				.replace('${dto.bet2}', d.bet2==null?'': d.bet2)
				.replace('${dto.opponent2}', d.opponent2);
			$('#matches').append(match);
		}
	})
}

Matches.mask=
'<section class="row col-lg-12 col-md-12 col-sm-12">' + //
	'<input class="betId" type="hidden" value="${dto.betId}"/>' +//
	'<input class="matchId" type="hidden" value="${dto.matchId}"/>' +//
	'<div><b>${dto.opponent1}</b></div>' + //
	'<div class="score">${dto.score}</div>' + //
	'<div class="bet">' + //
		'<input type="text" class="bet1 bet" value="${dto.bet1}"/> - <input type="text" class="bet2 bet" value="${dto.bet2}"/>' + //
	'</div>' + //
	'<div><b>${dto.opponent2}</b></div>' + //
'</section>';