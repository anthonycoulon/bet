package fr.valtech.bet.domain.repository.match;

import java.util.Date;
import java.util.List;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.MatchLevel;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;

public interface MatchRepository {

    List<fr.valtech.bet.domain.model.match.dto.MatchDto> findMatchByDateByUser(Date date, User currentUser);

    List<Date> findDates();

    fr.valtech.bet.domain.model.bet.Bet saveUserBet(MatchDto dto, User user);

    Bet findBet(Long matchId, Long userId);

    List<Match> findMatches();

    Match findMatche(Long id);

    void updateScoreMatch(Match match);

    List<Match> findByLevel(MatchLevel level);

    Match findMatche(Date tomorow);
}
