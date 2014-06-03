package fr.valtech.bet.domain.model.opponent;

import javax.persistence.*;

@Entity
@Table(name = "OPPONENT")
public class Opponent {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false, length = 80)
    private String name;

    @Column(name = "GR")
    private String group;

    @Column(name = "RANK", columnDefinition = "tinyint")
    private Integer rank;

    @Column(name = "FLAG")
    private String flag;

    public String getFlag(){return flag;}
    public void setFlag(String flag){this.flag = flag;}


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Opponent opponent = (Opponent) o;

        if (id != opponent.id)
            return false;
        if (name != null ? !name.equals(opponent.name) : opponent.name != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Opponent{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
