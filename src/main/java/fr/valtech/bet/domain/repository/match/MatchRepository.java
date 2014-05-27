package fr.valtech.bet.domain.repository.match;

import java.util.Date;
import java.util.List;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;

public interface MatchRepository {
    List<fr.valtech.bet.domain.model.match.dto.MatchDto> findMatchByDateByUser(Date date, User currentUser);

    List<Date> findDates();

    void saveUserBet(MatchDto dto, User user);
}
