package fr.valtech.bet.web.account;

import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.account.AccountService;
import fr.valtech.bet.service.exception.BetException;
import fr.valtech.bet.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("myaccount")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping
    public ModelAndView myAccount() {
        ModelAndView mav = new ModelAndView("myaccount");
        mav.addObject("user", userService.getConnectedUser());
        return mav;
    }

    @RequestMapping(value = "new")
    public ModelAndView newAccount() {
        return new ModelAndView("newaccount");
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody UserDto userDto) {
        if (createFormValidated(userDto)) {
            accountService.saveNewUser(userDto);
        }
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(@RequestBody UserDto userDto) throws BetException {
        userDto.setUsername(userService.getConnectedUser().getUsername());
        if (updateFormValidated(userDto)) {
            accountService.updateUser(userDto);
        }
    }

    private boolean updateFormValidated(UserDto userDto) {
        return userDto.getNewPassword().equals(userDto.getConfirmation()) || StringUtils.isNotBlank(userDto.getFirstName()) || StringUtils.isNotBlank(userDto.getName()) || StringUtils.isNotBlank(userDto.getCurrentPassword()) || userDto.getIsEmailGood();
    }

    private boolean createFormValidated(UserDto userDto) {
        return userDto.getNewPassword().equals(userDto.getConfirmation()) || StringUtils.isNotBlank(userDto.getFirstName()) || StringUtils.isNotBlank(userDto.getName()) || userDto.getIsEmailGood();
    }
}
