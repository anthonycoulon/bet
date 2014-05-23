package fr.valtech.bet.domain.repository.match;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;

@Repository
public class MatchRepositoryImpl extends BetRepository implements MatchRepository {

    @Override
    public List<Match> findMatchByDateByUser(Date date, User currentUser) {

        Query query = getEntityManager().createQuery("FROM Match m " + //
                "LEFT JOIN Bet b " + //
                "WHERE b.id=m.id " + //
                "AND b.gambler.id = :userId " + //
                "AND m.dateMatch = :dateMatch" + //
                "ORDER BY m.matchDate", Match.class); //
        query.setParameter("userId", currentUser.getId());
        query.setParameter("dateMatch", date);
        return query.getResultList();
    }
}
