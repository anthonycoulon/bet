package fr.valtech.bet.service.user;

import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.Avatar;
import fr.valtech.bet.domain.model.user.User;

public interface UserService {

    User findUser(String username);

    @Transactional(readOnly = true)
    User findUserById(Long id);

    @Transactional()
    void save(User user);

    User getConnectedUser();

    Avatar saveAvatar(Avatar avatar);

    User getConnectedUserWithAvatar();

    User findUserWithAvatar(String username);

    User findUserByIdWithAvatar(Long userId);
}
