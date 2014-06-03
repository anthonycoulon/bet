package fr.valtech.bet.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.Role;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.user.UserService;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    UserService userService;

    @Override
    @Transactional(readOnly = true)
    public void updateUser(UserDto userDto) {
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-1");

        //TODO: Refactore this part
        User user = new User();
        if(userDto.getId() != null){
            user = userService.findUserById(userDto.getId());
        }else{
            String username = String.format("%s.%s@valtech.fr", userDto.getFirstName(), userDto.getName()).toLowerCase();
            Role role = new Role();
            role.setId(2L);
            role.setRole("ROLE_USER");
            user.setUsername(username);
            user.setRole(role);
        }
        user.setName(userDto.getName());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(encoder.encodePassword(userDto.getNewPassword(), "ZLaTaNSalt"));

        userService.save(user);
    }
}
