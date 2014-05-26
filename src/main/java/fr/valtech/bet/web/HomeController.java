package fr.valtech.bet.web;

import fr.valtech.bet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login");
    }

    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", userService.findUsers());
        return mav;
    }

    @RequestMapping("login_error")
    public ModelAndView loginError() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("error", "Your account is not valid");
        return mav;
    }
}
