package fr.valtech.bet.domain.repository.match;

import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.user.User;

import java.util.Date;
import java.util.List;

public interface MatchRepository {
    List<Match> findMatchByDateByUser(Date date, User currentUser);
}
