package fr.valtech.bet.domain.repository.user;

import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl extends BetRepository implements UserRepository{


    @Override
    public List<User> findUsers() {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User findUser(String username) {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u where u.username=:username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

}
