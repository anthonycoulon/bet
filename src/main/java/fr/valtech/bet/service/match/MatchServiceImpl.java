package fr.valtech.bet.service.match;

import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.match.MatchRepository;
import fr.valtech.bet.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;
    
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<MatchDto> findMatchsByDateByUser(Date date, String username) {
        User user = userService.findUserByUsername(username);
        List<Match> matchs = matchRepository.findMatchByDateByUser(date, user.getId());
        List<MatchDto> matchDtos = new ArrayList<>();
        MatchDto dto = null;
        for (Match match : matchs) {
            dto.setOpponent1(match.getOpponent1().getName());
            dto.setOpponent2(match.getOpponent2().getName());
            dto.setMatchDate(match.getMatchDate());

            for (Bet bet : match.getBets()) {
                if((match.getId() == bet.getMatch().getId()) && StringUtils.isNotBlank(bet.getBet())){
                    dto.setBet1(extractBet1(bet.getBet()));
                    dto.setBet2(extractBet2(bet.getBet()));
                }
            }
            dto.setScore1(extractScore1(match.getScore()));
            dto.setScore2(extractScore2(match.getScore()));
            matchDtos.add(dto);
        }

        return matchDtos;
    }

    private Integer extractScore2(String scoreToSplit) {
        String[] score = scoreToSplit.split("-");
        return Integer.valueOf(score[1]);
    }

    private Integer extractScore1(String scoreToSplit) {
        String[] score = scoreToSplit.split("-");
        return Integer.valueOf(score[0]);
    }

    private Integer extractBet2(String bet) {
        String[] score = bet.split("-");
        return Integer.valueOf(score[1]);
    }

    private Integer extractBet1(String bet) {
        String[] score = bet.split("-");
        return Integer.valueOf(score[0]);
    }
}
