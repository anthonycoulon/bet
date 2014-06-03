package fr.valtech.bet.domain.repository.bet;

import java.util.Date;
import java.util.List;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.user.User;

public interface BetUserRepository {
    List<Bet> findBetUser(Date yesterday, User user);

    void save(Bet bet);
}
