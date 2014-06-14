package fr.valtech.bet.domain.repository.user;

import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.user.User;

import java.util.List;

public interface UserRepository {

    List<User> findUsersOrderedByScore();

    User findUser(String username);

    List<Bet> findUserConsideredBet(Long userId);

    List<User> findUsers();

    void save(User user);

    User findUserById(Long id);

}
