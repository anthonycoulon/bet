package fr.valtech.bet.domain.repository.user;

import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl extends BetRepository implements UserRepository {

    @Override
    public List<User> findUsersOrderedByScore() {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u WHERE u.role.role='ROLE_USER' ORDER BY u.score DESC, u.firstName ASC, u.name ASC",
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
    public User findUserById(Long id) {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u WHERE u.id=:id", User.class);
        query.setParameter("id", id);
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
