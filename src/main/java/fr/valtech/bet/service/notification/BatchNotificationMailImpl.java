package fr.valtech.bet.service.notification;

import java.util.List;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.match.MatchRepository;
import fr.valtech.bet.domain.repository.user.UserRepository;
import fr.valtech.bet.service.mail.MailService;

@Service
public class BatchNotificationMailImpl implements BatchNotificationMail {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MailService mailService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Scheduled(cron = "0 0 13 * * ?")
    public void notification() {
        String subject = "Valtech Bet : Y a un match demain !";
        DateTime tomorow = new DateMidnight().toDateTime().plusDays(1);

        if (matchRepository.findMatche(tomorow.toDate()) != null) {
            logger.info("Notification before match for th date {}", tomorow);

            List<User> users = userRepository.findUsersWhoAreNotified();
            for (User user : users) {
                mailService.send(subject, buildBody(user, tomorow), user.getUsername());
            }
        }
    }

    private String buildBody(User user, DateTime tomorow) {
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Salut ").append(user.getFirstName()).append("\n\n").append("Il y a un match le ")
                .append(tomorow.toString("dd/MM/yyyy")).append(" ! C'est le moment de saisir tes pronostiques.").append("\n\n")
                .append("Bon match.");
        return bodyBuilder.toString();
    }
}
