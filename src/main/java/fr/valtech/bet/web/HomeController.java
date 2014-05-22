package fr.valtech.bet.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public ModelAndView home(HttpServletRequest request) {
        return new ModelAndView("index");
    }

}
