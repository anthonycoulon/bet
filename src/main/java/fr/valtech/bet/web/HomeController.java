package fr.valtech.bet.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.service.user.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", userService.findUsers());
        return mav;
    }

}
