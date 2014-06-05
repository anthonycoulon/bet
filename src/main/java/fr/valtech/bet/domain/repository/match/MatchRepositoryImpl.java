package fr.valtech.bet.domain.repository.match;

import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.MatchLevel;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;

@Repository
public class MatchRepositoryImpl extends BetRepository implements MatchRepository {

    @Override
    public List<MatchDto> findMatchByDateByUser(Date date, User currentUser) {

        Session session = (Session) getEntityManager().getDelegate();
        SQLQuery query = session.createSQLQuery("SELECT distinct m.ID as matchId, b.ID as betId, o1.NAME as opponent1, o2.NAME opponent2," //
                + " m.SCORE as score, b.BET as bet, m.MATCH_DATE as matchDate, m.MATCH_TIME as matchTime," //
                + " m.ODDS1 as odds1, m.ODDS2 as odds2, m.MATCH_LEVEL as matchLevelOrdinal, o1.FLAG as flag1, o2.FLAG as flag2" //
                + " FROM bet.MATCHS m" //
                + "  INNER JOIN bet.OPPONENT o1 on o1.id=m.MATCH_OPPONENT1_FK" //
                + "  INNER JOIN bet.OPPONENT o2 on o2.id=m.MATCH_OPPONENT2_FK" //
                + "  LEFT JOIN (SELECT b.ID, mb.MATCH_ID, b.BET FROM bet.BET b" //
                + "    INNER JOIN bet.MATCH_BET mb on b.ID=mb.BET_ID" //
                + "  WHERE b.BET_USER_FK=:userId) b on b.MATCH_ID=m.ID" //
                + " WHERE m.MATCH_DATE=:date ORDER BY m.MATCH_TIME");//
        query.setParameter("date", date);
        query.setParameter("userId", currentUser.getId());

        query.addScalar("matchId", LongType.INSTANCE).addScalar("betId", LongType.INSTANCE).addScalar("opponent1", StringType.INSTANCE)
                .addScalar("opponent2", StringType.INSTANCE).addScalar("score", StringType.INSTANCE).addScalar("bet", StringType.INSTANCE)
                .addScalar("matchDate", DateType.INSTANCE).addScalar("matchTime", TimestampType.INSTANCE)
                .addScalar("odds1", IntegerType.INSTANCE).addScalar("odds2", IntegerType.INSTANCE).addScalar("matchLevelOrdinal", IntegerType.INSTANCE)
                .addScalar("flag1", StringType.INSTANCE).addScalar("flag2", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(MatchDto.class));
        return query.list();
    }

    @Override
    public List<Date> findDates() {
        return getEntityManager().createQuery("SELECT distinct m.matchDate FROM Match m", Date.class).getResultList();
    }

    @Override
    public Bet saveUserBet(MatchDto dto, User user) {
        Bet bet;
        Bet merged;
        Match match = getEntityManager().find(Match.class, dto.getMatchId());
        if (dto.getBetId() == null) {
            bet = new Bet();
            bet.setMatch(match);
            bet.setGambler(user);
            bet.setBet(constructBet(dto));
            merged = getEntityManager().merge(bet);

            updateMatchQuotes(dto, match, null, null);

        } else {
            bet = getEntityManager().find(Bet.class, dto.getBetId());

            Integer bet1 = Integer.valueOf(bet.getBet().split("-", 2)[0]);
            Integer bet2 = Integer.valueOf(bet.getBet().split("-", 2)[1]);

            bet.setBet(constructBet(dto));
            merged=getEntityManager().merge(bet);

            updateMatchQuotes(dto, match, bet1, bet2);
        }
        getEntityManager().flush();

        return merged;
    }

    @Override
    public List<Match> findMatches() {
        return getEntityManager().createQuery("FROM Match", Match.class).getResultList();
    }

    @Override
    public Match findMatche(Long id) {
        return getEntityManager().find(Match.class, id);
    }

    @Override
    public void updateScoreMatch(Match match) {
        getEntityManager().merge(match);
        getEntityManager().flush();
    }

    @Override
    public List<Match> findByLevel(MatchLevel level) {
        TypedQuery<Match> query = getEntityManager().createQuery("FROM Match m WHERE m.matchLevel=:level", Match.class);
        query.setParameter("level", level);

        return query.getResultList();
    }

    private Match updateMatchQuotes(MatchDto dto, Match match, Integer bet1, Integer bet2) {
        if (bet1 == null || bet2 == null) {
            if (dto.getBet1() > dto.getBet2()) {
                match.addOdds1(1);
            } else if (dto.getBet1() < dto.getBet2()) {
                match.addOdds2(1);
            }
        } else {
            if (dto.getBet1() > dto.getBet2() && bet1 <= bet2) {
                match.addOdds1(1);
                if(!bet1.equals(bet2)) {
                    match.addOdds2(-1);
                }
            } else if (dto.getBet1() < dto.getBet2() && bet1 >= bet2) {
                match.addOdds2(1);
                if(!bet1.equals(bet2)) {
                    match.addOdds1(-1);
                }
            } else if (dto.getBet1().equals(dto.getBet2()) && bet1 < bet2) {
                match.addOdds2(-1);
            } else if (dto.getBet1().equals(dto.getBet2()) && bet1 > bet2) {
                match.addOdds1(-1);
            }
        }
        getEntityManager().merge(match);

        return match;
    }

    private String constructBet(MatchDto dto) {
        return dto.getBet1() + "-" + dto.getBet2();
    }
}
