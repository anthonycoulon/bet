package fr.valtech.bet.service.user;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.User;

public interface UserService {

    @Transactional(readOnly = true)
    List<User> findUsers();

    @Transactional(readOnly = true)
    User findUserByUsername(String username);
}
