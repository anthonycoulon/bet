package fr.valtech.bet.domain.model.user;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NaturalId;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.bet.Bet;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NaturalId
    @Column(nullable = false, name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(length = 80, name = "NAME")
    private String name;

    @Column(length = 80, name = "FIRSTNAME")
    private String firstName;

    @ManyToOne
    @ForeignKey(name = "FK_USER_ROLE", inverseName = "FK_ROLE_USER")
    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
    private Role role;

    @OneToMany(mappedBy = "gambler")
    private List<Bet> bets;

    @Column(name = "SCORE")
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null)
            return false;
        if (!username.equals(user.username))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + username.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", role=").append(role);
        sb.append(", bets=").append(bets);
        sb.append('}');
        return sb.toString();
    }

    public void addBet(Bet bet) {
        if (bets == null) {
            bets = Lists.newArrayList();
        }
        bet.setGambler(this);
        bets.add(bet);
    }

    public void addScore(Integer scoreBet) {
        if (score == null) {
            score = 0;
        }
        score += scoreBet;
    }
}
