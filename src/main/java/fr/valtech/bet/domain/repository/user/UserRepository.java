package fr.valtech.bet.domain.repository.user;

import java.util.List;
import fr.valtech.bet.domain.model.user.User;

public interface UserRepository {

    List<User> findUsers();
}
