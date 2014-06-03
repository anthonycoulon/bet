package fr.valtech.bet.service.match;

import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MatchService {

    @Transactional(readOnly = true)
    List<MatchDto> findMatchByDateByUser(Date date, User currentUser);

    List<Date> findDates();

    List<fr.valtech.bet.domain.model.match.dto.QuotesDto> saveUserBets(List<MatchDto> dtos, User user);

    List<MatchDto> transform(List<Map<String, String>> dtos);

    List<Match> findByLevel(String level);
}
