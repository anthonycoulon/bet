package fr.valtech.bet.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findUser(String username) {
        return userRepository.findUser(username);
    }
}
