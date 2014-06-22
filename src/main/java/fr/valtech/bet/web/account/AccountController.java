package fr.valtech.bet.web.account;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserDto;
import fr.valtech.bet.service.account.AccountService;
import fr.valtech.bet.service.exception.BetException;
import fr.valtech.bet.service.user.UserService;

@Controller
@RequestMapping("myaccount")
public class AccountController {

    public static final ArrayList<String> EXTENSIONS = Lists.newArrayList("jpg", "jpeg", "JPG", "png", "gif");

    public static final int MAX_SIZE = 150000;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping
    public ModelAndView myAccount() {
        ModelAndView mav = new ModelAndView("myaccount");
        mav.addObject("user", userService.getConnectedUserWithAvatar());
        return mav;
    }

    @RequestMapping(value = "new")
    public ModelAndView newAccount() {
        return new ModelAndView("newaccount");
    }

    @RequestMapping(value = "forgotpwd")
    public ModelAndView forgottenPassword() {
        return new ModelAndView("forgottenpwd");
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

    @ResponseBody
    @RequestMapping(value = "forgotpwd/reset/{email:.+}")
    public void resetPwd(@PathVariable("email") String email) {
        if (StringUtils.isNotBlank(email)) {
            accountService.resetPwd(email);
        }
    }

    @ResponseBody
    @RequestMapping(value = "avatar", method = RequestMethod.POST)
    public String avatar(MultipartFile file) {
        if (!EXTENSIONS.contains(Files.getFileExtension(file.getOriginalFilename()))) {
            return "<div class=\"error\">Unknown image extension</div>";
        }
        if (file.getSize() > MAX_SIZE) {
            return "<div class=\"error\">Size of image too long</div>";
        }
        accountService.saveUserAvatar(file, userService.getConnectedUserWithAvatar());
        return "<img src=\"/bet/myaccount/download/avatar\" alt=\"avatar\" class=\"img-responsive avatar\"/>";
    }

    @RequestMapping("download/avatar")
    public void downloadAvatar(HttpServletResponse response) {
        User connectedUser = userService.getConnectedUserWithAvatar();
        response.setContentType(connectedUser.getAvatar().getContentType());
        try {
            FileCopyUtils.copy(connectedUser.getAvatar().getFile(), response.getOutputStream());
        } catch (IOException e) {
            Throwables.propagate(e);
        }
    }

    private boolean updateFormValidated(UserDto userDto) {
        return userDto.getNewPassword().equals(userDto.getConfirmation()) || StringUtils.isNotBlank(userDto.getFirstName())
                || StringUtils.isNotBlank(userDto.getName()) || StringUtils.isNotBlank(userDto.getCurrentPassword())
                || userDto.getIsEmailGood();
    }

    private boolean createFormValidated(UserDto userDto) {
        return userDto.getNewPassword().equals(userDto.getConfirmation()) || StringUtils.isNotBlank(userDto.getFirstName())
                || StringUtils.isNotBlank(userDto.getName()) || userDto.getIsEmailGood();
    }
}
