package fr.valtech.bet.web.rank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.service.rank.RankingService;

@Controller
@RequestMapping("ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @RequestMapping
    public ModelAndView ranking() {
        ModelAndView mav = new ModelAndView("ranking");
        mav.addObject("users", rankingService.transform(rankingService.findRankingUser()));
        return mav;
    }
}
