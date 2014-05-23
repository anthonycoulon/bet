package fr.valtech.bet.domain.repository.user;

import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.ValtechBetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl extends ValtechBetRepository implements UserRepository{


    @Override
    public List<User> findUsers() {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User findUserByUsername(String username) {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u LEFT JOIN FETCH u.bets b WHERE u.username=:username", User.class).setParameter("username", username);
        return query.getSingleResult();
    }

}
