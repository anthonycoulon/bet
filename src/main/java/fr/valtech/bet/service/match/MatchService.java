package fr.valtech.bet.service.match;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.User;

public interface MatchService {

    @Transactional(readOnly = true)
    List<fr.valtech.bet.domain.model.match.dto.MatchDto> findMatchByDateByUser(Date date, User currentUser);

    List<Date> findDates();
}
