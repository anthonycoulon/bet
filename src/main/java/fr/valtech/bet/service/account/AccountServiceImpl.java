package fr.valtech.bet.service.account;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import fr.valtech.bet.domain.model.user.Role;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.exception.BetException;
import fr.valtech.bet.service.user.UserService;

@Service
public class AccountServiceImpl implements AccountService{

    public static final String SALT_KEY = "ZLaTaNSalt";

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public void updateUser(UserDto userDto) throws BetException {
        User user = userService.findUser(userDto.getUsername());
        String currentPwd = encodePassword(userDto.getCurrentPassword());

        if(userDto.getUsername().equals(user.getUsername()) && currentPwd.equals(user.getPassword())){
            user.setName(userDto.getName());
            user.setFirstName(userDto.getFirstName());

            if(StringUtils.isNotBlank(userDto.getNewPassword())){
                user.setPassword(encodePassword(userDto.getNewPassword()));
            }
            userService.save(user);
        }else {
            throw new BetException("Wrong Current Password or Username is not equals to the one in database!");
        }
    }

    @Override
    @Transactional
    public void saveNewUser(UserDto userDto) {
        Role role = new Role();
        role.setId(2L);
        role.setRole("ROLE_USER");

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setRole(role);
        user.setName(userDto.getName());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(encodePassword(userDto.getNewPassword()));
        userService.save(user);
    }

    @Override
    public void resetPwd(String email) {
        User user = userService.findUser(email);
        String newPassword = generatePwd(user);
        user.setPassword(newPassword);
        userService.save(user);
    }

    private String generatePwd(User user) {
        StringBuilder newPassword = new StringBuilder();
        newPassword.append(StringUtils.lowerCase(user.getFirstName().substring(0, 1)));
        newPassword.append(StringUtils.lowerCase(user.getName()));
        return encodePassword(newPassword.toString());
    }

    private String encodePassword(String password){
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-1");
        return encoder.encodePassword(password, SALT_KEY);
    }

    @Override
    @Transactional
    public void saveUserAvatar(MultipartFile file, User connectedUser) {
        try {
            connectedUser.setAvatar(file.getBytes());
            connectedUser.setContentType(file.getContentType());
            userService.save(connectedUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}