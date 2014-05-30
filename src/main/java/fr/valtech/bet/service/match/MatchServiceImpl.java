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
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.match.dto.QuotesDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.match.MatchRepository;

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

            calculateQuote(match);
        }

        return matches;
    }

    private void calculateQuote(MatchDto match) {
        int total = match.getQuote1() + match.getQuote2();
        if (total == 0) {
            match.setQuote1(50);
            match.setQuote2(50);
        } else {
            match.setQuote1(percent(match.getQuote1(), total));
            match.setQuote2(percent(match.getQuote2(), total));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Date> findDates() {
        return matchRepository.findDates();
    }

    @Override
    @Transactional
    public List<QuotesDto> saveUserBets(List<MatchDto> dtos, User user) {
        DateTime today = new DateTime();
        List<QuotesDto> quotes = Lists.newArrayList();
        for (MatchDto dto : dtos) {
            if ((dto.getBet1() != null && dto.getBet2() != null) && today.isBefore(dto.getMatchTime().getTime())) {
                Match match = matchRepository.saveUserBet(dto, user);
                quotes.add(transformQuotes(match));
            }
        }
        return quotes;
    }

    private QuotesDto transformQuotes(Match match) {
        QuotesDto quoteDto = new QuotesDto();
        quoteDto.setMatchId(match.getId());
        int total = match.getQuote1() + match.getQuote2();
        if (total == 0) {
            quoteDto.setQuote1(50);
            quoteDto.setQuote2(50);
        } else {
            quoteDto.setQuote1(percent(match.getQuote1(), total));
            quoteDto.setQuote2(percent(match.getQuote2(), total));
        }
        return quoteDto;
    }

    private int percent(Integer value, int total) {
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
