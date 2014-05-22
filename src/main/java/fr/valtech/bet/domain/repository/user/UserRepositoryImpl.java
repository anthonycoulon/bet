package fr.valtech.bet.domain.repository.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.user.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "betPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public List<User> findUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

}
