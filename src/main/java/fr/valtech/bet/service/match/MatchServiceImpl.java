package fr.valtech.bet.service.match;

import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.match.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Match> findMatchByDateByUser(Date date, User currentUser) {
        List<Match> matchs = matchRepository.findMatchByDateByUser(date, currentUser);
        MatchDto dto = null;
        for (Match match : matchs) {
            dto.setOpponent1(match.getOpponent1().getName());
            dto.setOpponent2(match.getOpponent2().getName());
            dto.setMatchDate(match.getMatchDate());
        }

        return null;
    }
}
