package fr.valtech.bet.service.account;

import fr.valtech.bet.domain.model.user.Role;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
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

            User user = userService.findUser(userDto.getUsername());
            user.setName(userDto.getName());
            user.setFirstName(userDto.getFirstName());
            user.setPassword(encoder.encodePassword(userDto.getNewPassword(), "ZLaTaNSalt"));
            if(userDto.getUsername() == user.getUsername() && userDto.getCurrentPassword().equals(user.getPassword())){
                userService.save(user);
            }
        }

    @Override
    @Transactional(readOnly = true)
    public void saveNewUser(UserDto userDto) {
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-1");

        Role role = new Role();
        role.setId(2L);
        role.setRole("ROLE_USER");

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setRole(role);
        user.setName(userDto.getName());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(encoder.encodePassword(userDto.getNewPassword(), "ZLaTaNSalt"));
        userService.save(user);
    }
}