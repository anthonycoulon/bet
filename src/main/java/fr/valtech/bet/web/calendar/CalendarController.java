package fr.valtech.bet.web.calendar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.service.match.MatchService;

@Controller
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    private MatchService matchService;

    @RequestMapping()
    public ModelAndView matches(@RequestParam("level") String level) {
        ModelAndView mav=new ModelAndView("calendar");
        List<Match> matches = matchService.findByLevel(level);
        if (matches != null && matches.size() > 0) {
            mav.addObject("matches", matches);
            mav.addObject("matchLevel", matches.get(0) == null ? "" : matches.get(0).getMatchLevel().getLabel());
        }
        return mav;
    }
}
