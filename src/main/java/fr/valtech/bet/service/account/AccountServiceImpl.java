package fr.valtech.bet.service.account;

import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    UserService userService;

    @Override
    @Transactional(readOnly = true)
    public void updateUser(UserDto userDto) {
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-1");

        User user = userService.findUserById(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(encoder.encodePassword(userDto.getNewPassword(), "ZLaTaNSalt"));

        userService.save(user);
    }
}
