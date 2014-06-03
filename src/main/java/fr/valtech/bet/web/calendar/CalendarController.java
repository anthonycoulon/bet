package fr.valtech.bet.web.calendar;

import fr.valtech.bet.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Lyaz on 01/06/2014.
 */
@Controller
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    private MatchService matchService;

    @RequestMapping(method = RequestMethod.GET)
    public String matches(@RequestParam("level") String level, Model model)
    {
        model.addAttribute("matches",matchService.findByLevel(level));
        return "calendar";
    }
}
