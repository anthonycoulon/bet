package fr.valtech.bet.domain.repository.bet;

import java.util.Date;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.user.User;

public interface BetUserRepository {
    java.util.List<Bet> findBetUser(Date yesterday, User user);
}
