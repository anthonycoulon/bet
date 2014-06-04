package fr.valtech.bet.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            log.info("user connected : {}", ((User) principal).getUsername());
            response.sendRedirect("match");
        } else {
            response.sendRedirect("login");
        }
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
