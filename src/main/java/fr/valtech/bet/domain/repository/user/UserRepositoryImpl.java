package fr.valtech.bet.domain.repository.user;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;

@Repository
public class UserRepositoryImpl extends BetRepository implements UserRepository {

    @Override
    public List<User> findUsersOrderedByScore() {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u WHERE u.role.role='ROLE_USER' ORDER BY u.score DESC",
                User.class);
        return query.getResultList();
    }

    @Override
    public User findUser(String username) {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u WHERE u.username=:username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public List<User> findUsers() {
        return getEntityManager().createQuery("FROM User u WHERE u.role.role='ROLE_USER'", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        getEntityManager().merge(user);
        getEntityManager().flush();
    }

}
