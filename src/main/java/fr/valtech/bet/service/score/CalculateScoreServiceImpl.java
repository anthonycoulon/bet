package fr.valtech.bet.service.score;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.bet.BetUserRepository;
import fr.valtech.bet.domain.repository.user.UserRepository;

@Service
public class CalculateScoreServiceImpl implements CalculateScoreService {

    @Autowired
    private BetUserRepository betRepository;

    @Autowired
    private UserRepository userRepository;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Transactional
    @Scheduled(cron = "0 0 5 * * ?")
    @Override
    public void calculateScore() {
        Date yesterday = new DateTime().toDateMidnight().minusDays(1).toDate();
        log.info("calculate score for matches of {}", yesterday);
        List<User> users = userRepository.findUsers();
        for (User user : users) {
            List<Bet> bets = betRepository.findBetUser(yesterday, user);
            Integer scoreUser = 0;
            for (Bet bet : bets) {
                Integer scoreBet = 0;
                Match match = bet.getMatch();
                if (StringUtils.isBlank(match.getScore())) {
                    continue;
                }

                scoreBet = calculateScore(bet, scoreBet, match);
                scoreBet = calculateBonusLevel(scoreBet, match);
                scoreUser+=scoreBet;
            }
            user.addScore(scoreUser);
            userRepository.save(user);
        }
    }

    private Integer calculateScore(Bet bet, Integer scoreBet, Match match) {
        Integer bet1 = Integer.valueOf(bet.getBet().split("-", 2)[0]);
        Integer bet2 = Integer.valueOf(bet.getBet().split("-", 2)[1]);

        Integer score1 = Integer.valueOf(match.getScore().split("-", 2)[0]);
        Integer score2 = Integer.valueOf(match.getScore().split("-", 2)[1]);

        int total = match.getQuote1() + match.getQuote2();
        int p1 = percent(match.getQuote1(), total);
        int p2 = percent(match.getQuote2(), total);

        if (bet1 > bet2 && score1 > score2) {
            scoreBet++;
            if(p1<45) {
                scoreBet+=3;
            }
        } else if (bet1 < bet2 && score1 < score2) {
            scoreBet++;
            if(p2<45) {
                scoreBet+=3;
            }
        } else if (bet1.equals(bet2) && score1.equals(score2)) {
            scoreBet++;
            if(p1>60 || p2>60) {
                scoreBet+=3;
            }
        }
        if (bet1.equals(score1) && bet2.equals(score2)) {
            scoreBet += 2;
        }
        return scoreBet;
    }

    private Integer calculateBonusLevel(Integer scoreBet, Match match) {
        switch (match.getMatchLevel()) {
            case eighth:
                scoreBet*=2;
                break;
            case quarter:
                scoreBet*=3;
                break;
            case semi:
                scoreBet*=4;
                break;
            case final2:
                scoreBet*=5;
                break;
            case final1:
                scoreBet*=6;
                break;
            default:
                break;
        }
        return scoreBet;
    }

    private int percent(Integer value, int total) {
        if (total == 0) {
            return 50;
        }
        return new BigDecimal(value * 100).divide(new BigDecimal(total), 0, BigDecimal.ROUND_HALF_EVEN).intValue();
    }
}
