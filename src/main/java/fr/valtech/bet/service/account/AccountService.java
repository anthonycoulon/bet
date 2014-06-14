package fr.valtech.bet.service.account;

import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.exception.BetException;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
    @Transactional(readOnly = true)
    void updateUser(UserDto userDto) throws BetException;

    @Transactional(readOnly = true)
    void saveNewUser(UserDto userDto);
}
