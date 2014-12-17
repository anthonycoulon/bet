package fr.valtech.bet.domain.repository.user;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.user.Avatar;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.BetRepository;

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
    public Avatar saveAvatar(Avatar avatar) {
        Avatar merged = getEntityManager().merge(avatar);
        getEntityManager().flush();
        return merged;
    }

    @Override
    public User findUserWithAvatar(String username) {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u left join fetch u.avatar WHERE u.username=:username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public User findUserByIdWithAvatar(Long userId) {
        TypedQuery<User> query = getEntityManager().createQuery("FROM User u left join fetch u.avatar WHERE u.id=:id", User.class);
        query.setParameter("id", userId);
        return query.getSingleResult();
    }

    @Override
    public List<User> findUsersWhoAreNotified() {
        return getEntityManager().createQuery("FROM User u where u.isNotified=true", User.class).getResultList();
    }

    @Override
    public List<Bet> findUserConsideredBet(Long userId) {
        TypedQuery<Bet> query = getEntityManager().createQuery("FROM Bet b WHERE b.considered=true AND b.gambler.id=:userId ORDER BY b.match.timeDate", Bet.class);
        query.setParameter("userId", userId);
        return query.getResultList();
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
