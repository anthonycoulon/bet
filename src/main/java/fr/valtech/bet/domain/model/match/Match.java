package fr.valtech.bet.domain.model.match;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.valtech.bet.domain.model.stadium.Stadium;
import org.hibernate.annotations.ForeignKey;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.opponent.Opponent;

@Entity
@Table(name = "MATCHS")
public class Match {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MATCH_OPPONENT1_FK")
    private Opponent opponent1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MATCH_OPPONENT2_FK")
    private Opponent opponent2;

    @Column(name = "MATCH_DATE")
    private Date matchDate;

    @Column(name = "MATCH_TIME")
    private Date timeDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MATCH_STADIUM_FK")
    private Stadium stadium;

    @Column(name="MATCH_STAGE")
    private byte stage;

    @Column(name = "SCORE")
    private String score;

    @OneToMany
    @ForeignKey(name = "FK_MATCH_BET", inverseName = "FK_BET_MATCH")
    @JoinTable(name = "MATCH_BET", joinColumns = { @JoinColumn(name = "MATCH_ID", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "BET_ID", referencedColumnName = "ID") })
    private List<Bet> bets;

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

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public Stadium getStadium() {return stadium; }

    public void setStadium(Stadium stadium) {this.stadium = stadium;}
    public byte getStage() {return stage;}

    public void setStage(byte stage) {this.stage = stage;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (id != match.id) return false;
        if (matchDate != null ? !matchDate.equals(match.matchDate) : match.matchDate != null) return false;
        if (opponent1 != null ? !opponent1.equals(match.opponent1) : match.opponent1 != null) return false;
        if (opponent2 != null ? !opponent2.equals(match.opponent2) : match.opponent2 != null) return false;

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
        sb.append(", bets=").append(bets);
        sb.append('}');
        return sb.toString();
    }

    public void addBet(Bet bet) {
        if(bets==null) {
            bets= Lists.newArrayList();
        }
        bet.setMatch(this);
        bets.add(bet);
    }
}
