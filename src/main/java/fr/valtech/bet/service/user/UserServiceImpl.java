package fr.valtech.bet.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional(readOnly = true)
    public User findUser(String username) {
        return userRepository.findUser(username);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getConnectedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug("principal : ", principal);
        String username = ((org.springframework.security.core.userdetails.User) principal).getUsername();
        return findUser(username);
    }
}
