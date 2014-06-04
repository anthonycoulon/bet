package fr.valtech.bet.domain.model.match;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import fr.valtech.bet.domain.model.opponent.Opponent;
import fr.valtech.bet.domain.model.stadium.Stadium;

@Entity
@Table(name = "MATCHS")
public class Match {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "MATCH_OPPONENT1_FK", nullable = false)
    private Opponent opponent1;

    @OneToOne
    @JoinColumn(name = "MATCH_OPPONENT2_FK", nullable = false)
    private Opponent opponent2;

    @Column(name = "MATCH_DATE", nullable = false)
    private Date matchDate;

    @Column(name = "MATCH_TIME")
    private Date timeDate;

    @OneToOne
    @JoinColumn(name = "MATCH_STADIUM_FK")
    private Stadium stadium;

    @Column(name = "SCORE")
    private String score;

    @Column(name = "ODDS1", columnDefinition = "integer default 0")
    private Integer odds1;

    @Column(name = "ODDS2", columnDefinition = "integer default 0")
    private Integer odds2;

    @Column(name = "MATCH_LEVEL", nullable = false)
    @Enumerated
    private MatchLevel matchLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Opponent getOpponent1() {
        return opponent1;
    }

    public void setOpponent1(Opponent opponent1) {
        this.opponent1 = opponent1;
    }

    public Opponent getOpponent2() {
        return opponent2;
    }

    public void setOpponent2(Opponent opponent2) {
        this.opponent2 = opponent2;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Integer getOdds1() {
        return odds1;
    }

    public void setOdds1(Integer odds1) {
        this.odds1 = odds1;
    }

    public Integer getOdds2() {
        return odds2;
    }

    public void setOdds2(Integer odds2) {
        this.odds2 = odds2;
    }

    public MatchLevel getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(MatchLevel matchLevel) {
        this.matchLevel = matchLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Match match = (Match) o;

        if (id != match.id)
            return false;
        if (matchDate != null ? !matchDate.equals(match.matchDate) : match.matchDate != null)
            return false;
        if (opponent1 != null ? !opponent1.equals(match.opponent1) : match.opponent1 != null)
            return false;
        if (opponent2 != null ? !opponent2.equals(match.opponent2) : match.opponent2 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (opponent1 != null ? opponent1.hashCode() : 0);
        result = 31 * result + (opponent2 != null ? opponent2.hashCode() : 0);
        result = 31 * result + (matchDate != null ? matchDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Match{");
        sb.append("id=").append(id);
        sb.append(", opponent1=").append(opponent1);
        sb.append(", opponent2=").append(opponent2);
        sb.append(", matchDate=").append(matchDate);
        sb.append(", timeDate=").append(timeDate);
        sb.append(", score='").append(score).append('\'');
        sb.append(", odds1=").append(odds1);
        sb.append(", odds2=").append(odds2);
        sb.append(", matchLevel=").append(matchLevel);
        sb.append('}');
        return sb.toString();
    }

    public void addOdds1(int value) {
        if (odds1 == null) {
            odds1 = 0;
        }
        odds1 += value;
    }

    public void addOdds2(int value) {
        if (odds2 == null) {
            odds2 = 0;
        }
        odds2 += value;
    }
}
