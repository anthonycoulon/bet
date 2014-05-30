package fr.valtech.bet.service.match;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;

public interface MatchService {

    @Transactional(readOnly = true)
    List<MatchDto> findMatchByDateByUser(Date date, User currentUser);

    List<Date> findDates();

    List<fr.valtech.bet.domain.model.match.dto.QuotesDto> saveUserBets(List<MatchDto> dtos, User user);

    List<MatchDto> transform(List<Map<String, String>> dtos);
}
