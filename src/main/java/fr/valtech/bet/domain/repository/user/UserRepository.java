package fr.valtech.bet.domain.repository.user;

import java.util.List;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.user.Avatar;
import fr.valtech.bet.domain.model.user.User;

public interface UserRepository {

    List<User> findUsersOrderedByScore();

    User findUser(String username);

    List<Bet> findUserConsideredBet(Long userId);

    List<User> findUsers();

    void save(User user);

    User findUserById(Long id);

    Avatar saveAvatar(Avatar avatar);

    User findUserWithAvatar(String username);

    User findUserByIdWithAvatar(Long userId);
}
