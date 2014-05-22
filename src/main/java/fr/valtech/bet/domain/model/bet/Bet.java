package fr.valtech.bet.domain.model.bet;

import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "BET")
public class Bet {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="BET_USER_FK")
    private User gambler;

    @Column(name = "BET")
    private String bet;

    @OneToOne
    private Match match;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getGambler() {
        return gambler;
    }

    public void setGambler(User gambler) {
        this.gambler = gambler;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (id != bet.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bet{");
        sb.append("id=").append(id);
        sb.append(", gambler=").append(gambler);
        sb.append(", bet='").append(bet).append('\'');
        sb.append(", match=").append(match);
        sb.append('}');
        return sb.toString();
    }
}
