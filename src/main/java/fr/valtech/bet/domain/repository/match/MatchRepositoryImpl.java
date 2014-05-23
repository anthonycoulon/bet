package fr.valtech.bet.domain.repository.match;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;

import fr.valtech.bet.domain.repository.ValtechBetRepository;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.match.Match;

@Repository
public class MatchRepositoryImpl extends ValtechBetRepository implements MatchRepository {

    @Override
    public List<Match> findMatchByDateByUser(Date date, Long userId) {

        Query query = getEntityManager().createQuery("SELECT m FROM Match m " + //
                "LEFT JOIN m.bets b " + //
                "WHERE b.gambler.id = :userId " + //
                "AND m.matchDate = :matchDate " + //
                "ORDER BY m.matchDate", Match.class); //
        query.setParameter("userId", userId);
        query.setParameter("matchDate", date);
        return query.getResultList();
    }
}
