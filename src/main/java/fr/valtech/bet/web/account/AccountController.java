package fr.valtech.bet.web.account;

import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.account.AccountService;
import fr.valtech.bet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RequestMapping
    public ModelAndView myAccount() {
        ModelAndView mav = new ModelAndView("myaccount");
        mav.addObject("user", getUser());
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody UserDto userDto) {
        accountService.updateUser(userDto);
    }

    private User getUser() {
        String username = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return userService.findUser(username);
    }
}
