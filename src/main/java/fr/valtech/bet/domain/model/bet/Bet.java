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

    @OneToOne
    @JoinColumn(name="BET_USER_FK")
    private User gambler;

    @Enumerated
    @Column(name = "CHOICE")
    private BetChoice choice;

    @ManyToOne
    @JoinColumn(name = "MATCH_ID")
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

    public BetChoice getChoice() {
        return choice;
    }

    public void setChoice(BetChoice choice) {
        this.choice = choice;
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
        sb.append(", choice=").append(choice);
        sb.append(", match=").append(match);
        sb.append('}');
        return sb.toString();
    }
}
