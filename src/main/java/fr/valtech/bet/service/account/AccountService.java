package fr.valtech.bet.service.account;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.exception.BetException;

public interface AccountService {
    @Transactional
    void updateUser(UserDto userDto) throws BetException;

    @Transactional
    void saveNewUser(UserDto userDto);

    @Transactional(readOnly = true)
    void resetPwd(String email);

    void saveUserAvatar(MultipartFile file, User connectedUser);
}
