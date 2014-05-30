package fr.valtech.bet.service.score;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

public interface CalculateScoreService {
    @Transactional
    @Scheduled(cron = "0 * * * * ?")
    void calculateScore();
}
