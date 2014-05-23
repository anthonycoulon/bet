package fr.valtech.bet.service.match;

import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface MatchService {

    @Transactional(readOnly = true)
    List<MatchDto> findMatchsByDateByUser(Date date, String username);
}
