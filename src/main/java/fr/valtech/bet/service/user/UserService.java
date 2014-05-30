package fr.valtech.bet.service.user;

import fr.valtech.bet.domain.model.user.User;

public interface UserService {

    User findUser(String username);

    User getConnectedUser();
}
