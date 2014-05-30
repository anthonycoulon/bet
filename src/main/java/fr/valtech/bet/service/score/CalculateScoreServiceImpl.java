package fr.valtech.bet.service.score;

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
        List<User> users= userRepository.findUsers();
        for (User user : users) {
            List<Bet> bets = betRepository.findBetUser(yesterday, user);
            Integer scoreBet=0;
            for (Bet bet : bets) {
                Integer bet1 = Integer.valueOf(bet.getBet().split("-",2)[0]);
                Integer bet2 = Integer.valueOf(bet.getBet().split("-", 2)[1]);

                Match match = bet.getMatch();
                if(StringUtils.isBlank(match.getScore())){
                    continue;
                }
                Integer score1 = Integer.valueOf(match.getScore().split("-", 2)[0]);
                Integer score2 = Integer.valueOf(match.getScore().split("-",2)[1]);

                if(bet1>bet2 && score1>score2) {
                    scoreBet++;
                }else if(bet1<bet2 && score1<score2) {
                    scoreBet++;
                }else if(bet1.equals(bet2) && score1.equals(score2)) {
                    scoreBet++;
                }
                if(bet1.equals(score1) && bet2.equals(score2)) {
                    scoreBet+=2;
                }

            }
            user.addScore(scoreBet);
            userRepository.save(user);
        }
    }
}
