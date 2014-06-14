package fr.valtech.bet.domain.repository.bet;

import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;

@Repository
public class BetUserRepositoryImpl extends BetRepository implements BetUserRepository {
    @Override
    public List<Bet> findBetUser(Date today, User user) {
        TypedQuery<Bet> query = getEntityManager().createQuery("FROM Bet b WHERE b.gambler.id=:userId AND b.match.matchDate<=:today AND b.considered=false", Bet.class);
        query.setParameter("userId", user.getId());
        query.setParameter("today", today);
        return query.getResultList();
    }

    @Override
    public void save(Bet bet) {
        getEntityManager().merge(bet);
    }
}
