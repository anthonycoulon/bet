package fr.valtech.bet.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login");
    }

    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView("index");
    }

    @RequestMapping("login_error")
    public ModelAndView loginError() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("error", "Your account is not valid");
        return mav;
    }
}
