package fr.valtech.bet.domain.model.match;

import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.opponent.Opponent;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MATCH")
public class Match {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name="MATCH_OPPONENT1_FK")
    private Opponent opponent1;

    @OneToOne
    @JoinColumn(name="MATCH_OPPONENT2_FK")
    private Opponent opponent2;

    @Column(name = "MATCH_DATE")
    private Date matchDate;

    @Column(name = "SCORE")
    private String score;

    @Column(name = "BETS")
    @OneToMany(mappedBy = "match")
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
        sb.append(", score='").append(score).append('\'');
        sb.append(", bets=").append(bets);
        sb.append('}');
        return sb.toString();
    }
}
