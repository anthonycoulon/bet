package fr.valtech.bet.domain.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(length = 30, nullable = false, name = "ROLE")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Role role1 = (Role) o;

        if (id != null ? !id.equals(role1.id) : role1.id != null)
            return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
