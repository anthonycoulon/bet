package fr.valtech.bet.service.user;

import fr.valtech.bet.domain.model.user.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    User findUser(String username);

    @Transactional(readOnly = true)
    void save(User user);

    User getConnectedUser();
}
