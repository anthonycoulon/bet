package fr.valtech.bet.domain.repository.match;

import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;

@Repository
public class MatchRepositoryImpl extends BetRepository implements MatchRepository {

    @Override
    public List<MatchDto> findMatchByDateByUser(Date date, User currentUser) {

        Session session = (Session) getEntityManager().getDelegate();
        SQLQuery query = session.createSQLQuery(
                "SELECT m.id as matchId, b.id as betId, o1.NAME as opponent1, o2.NAME opponent2, m.SCORE as score, b.BET as bet, m.MATCH_DATE as matchDate" + //
                " FROM bet.MATCHS m " + //
                "  INNER JOIN bet.OPPONENT o1 on o1.id=m.MATCH_OPPONENT1_FK" +//
                "  INNER JOIN bet.OPPONENT o2 on o2.id=m.MATCH_OPPONENT2_FK" +//
                "  LEFT JOIN bet.MATCH_BET mb on m.ID=mb.MATCH_ID " +//
                "  LEFT JOIN (SELECT b.ID, b.BET from bet.BET b INNER JOIN bet.USER u on b.BET_USER_FK=u.ID WHERE u.ID=:userId) b on b.ID=mb.BET_ID" +//
                " WHERE m.MATCH_DATE=:date ORDER BY m.MATCH_DATE");//
        query.setParameter("date", date);
        query.setParameter("userId", currentUser.getId());

        query.addScalar("matchId", LongType.INSTANCE)
            .addScalar("betId", LongType.INSTANCE)
            .addScalar("opponent1", StringType.INSTANCE)
            .addScalar("opponent2", StringType.INSTANCE)
            .addScalar("score", StringType.INSTANCE)
            .addScalar("bet", StringType.INSTANCE)
            .addScalar("matchDate", DateType.INSTANCE)
            .setResultTransformer(Transformers.aliasToBean(MatchDto.class));
        return query.list();
    }
}
