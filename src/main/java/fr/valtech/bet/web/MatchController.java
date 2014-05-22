package fr.valtech.bet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("match")
public class MatchController {

    @RequestMapping
    public ModelAndView match() {
        return new ModelAndView("match");
    }
}
