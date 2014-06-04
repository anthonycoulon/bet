package fr.valtech.bet.web.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.service.match.MatchService;

@Controller
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    private MatchService matchService;

    @RequestMapping()
    public ModelAndView matches(@RequestParam("level") String level) {
        ModelAndView mav=new ModelAndView("calendar");
        mav.addObject("matches", matchService.findByLevel(level));
        return mav;
    }
}
