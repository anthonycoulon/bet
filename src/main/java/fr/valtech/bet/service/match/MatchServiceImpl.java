package fr.valtech.bet.service.match;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.MatchLevel;
import fr.valtech.bet.domain.model.match.dto.AdminMatchDto;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.match.dto.OddsDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.match.MatchRepository;
import fr.valtech.bet.service.exception.BetException;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MatchDto> findMatchByDateByUser(Date date, User currentUser) {
        List<MatchDto> matches = matchRepository.findMatchByDateByUser(date, currentUser);
        for (MatchDto match : matches) {
            String bet = match.getBet();
            if (StringUtils.isNotBlank(bet)) {
                String[] splitedBet = bet.split("-", 2);
                match.setBet1(Integer.valueOf(splitedBet[0]));
                match.setBet2(Integer.valueOf(splitedBet[1]));
            }
            MatchLevel matchLevel = MatchLevel.values()[match.getMatchLevelOrdinal()];
            match.setMatchLevel(matchLevel.getLabel());
            match.setMatchLevelShort(matchLevel.getShortLabel());
            calculateQuote(match);
        }

        return matches;
    }

    private void calculateQuote(MatchDto match) {
        int total = match.getOdds1() + match.getOdds2();
        match.setOdds1(percent(match.getOdds1(), total));
        match.setOdds2(percent(match.getOdds2(), total));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Date> findDates() {
        return matchRepository.findDates();
    }

    @Override
    @Transactional
    public List<OddsDto> saveUserBets(List<MatchDto> dtos, User user) {
        DateTime today = new DateTime();
        List<OddsDto> quotes = Lists.newArrayList();
        for (MatchDto dto : dtos) {
            if ((dto.getBet1() != null && dto.getBet2() != null) && today.isBefore(dto.getMatchTime().getTime())) {
                quotes.add(transformQuotes(matchRepository.saveUserBet(dto, user)));
            } else if (!(dto.getBet1() == null && dto.getBet2() == null) || today.isAfter(dto.getMatchTime().getTime())) {
                Throwables.propagate(new BetException(String.format("THe user %s entered a wrong score", user.getUsername())));
            }
        }
        return quotes;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Match> findByLevel(String level) {
        return matchRepository.findByLevel(MatchLevel.valueOf(level));
    }

    private OddsDto transformQuotes(Bet bet) {
        Match match = bet.getMatch();
        OddsDto quoteDto = new OddsDto();
        quoteDto.setMatchId(match.getId());
        int total = match.getOdds1() + match.getOdds2();
        quoteDto.setOdds1(percent(match.getOdds1(), total));
        quoteDto.setOdds2(percent(match.getOdds2(), total));
        quoteDto.setBetId(bet.getId());
        return quoteDto;
    }

    private int percent(Integer value, int total) {
        if (total == 0) {
            return 50;
        }
        return new BigDecimal(value * 100).divide(new BigDecimal(total), 0, BigDecimal.ROUND_HALF_EVEN).intValue();
    }

    @Override
    public List<MatchDto> transform(List<Map<String, String>> dtos) {
        List<MatchDto> matches = Lists.newArrayList();
        for (Map<String, String> dto : dtos) {
            MatchDto match = new MatchDto();
            match.setBetId(longValue(dto.get("betId")));
            match.setMatchId(longValue(dto.get("matchId")));
            match.setBet1(intValue(dto.get("bet1")));
            match.setBet2(intValue(dto.get("bet2")));
            match.setMatchTime(dateValue(dto.get("matchTime")));
            matches.add(match);
        }

        return matches;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminMatchDto> findMatches() {
        return transformAdminMatch(matchRepository.findMatches());
    }

    @Override
    @Transactional
    public void updateScoreMatch(List<Map<String, String>> dtos) {
        for (Map<String, String> dto : dtos) {
            Match match = matchRepository.findMatche(Long.parseLong(dto.get("id")));
            match.setScore(dto.get("score"));
            matchRepository.updateScoreMatch(match);
        }

    }

    private List<AdminMatchDto> transformAdminMatch(List<Match> matches) {
        List<AdminMatchDto> dtos = Lists.newArrayList();
        for (Match match : matches) {
            AdminMatchDto dto = new AdminMatchDto();
            dto.setId(match.getId());
            dto.setMatchTime(match.getMatchDate());
            dto.setOpponent1(match.getOpponent1().getName());
            dto.setOpponent2(match.getOpponent2().getName());
            dto.setScore(match.getScore());
            dtos.add(dto);
        }
        return dtos;
    }

    private Date dateValue(String val) {
        if (StringUtils.isBlank(val)) {
            return null;
        }
        return new Date(longValue(val));
    }

    private Long longValue(String val) {
        return StringUtils.isBlank(val) ? null : Long.valueOf(val);
    }

    private Integer intValue(String val) {
        return StringUtils.isBlank(val) ? null : Integer.valueOf(val);
    }
}
