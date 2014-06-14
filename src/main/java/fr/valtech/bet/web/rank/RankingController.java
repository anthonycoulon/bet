package fr.valtech.bet.web.rank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.service.rank.RankingService;
import fr.valtech.bet.service.user.UserService;

@Controller
@RequestMapping("ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView ranking() {
        ModelAndView mav = new ModelAndView("ranking");
        mav.addObject("users", rankingService.transform(rankingService.findRankingUser()));
        mav.addObject("userId", userService.getConnectedUser().getId());
        return mav;
    }

    @RequestMapping("user/detail/{userId}/{userRank}")
    public ModelAndView userDetail(@PathVariable Long userId, @PathVariable Integer userRank) {
        ModelAndView mav = new ModelAndView("user/detail");
        mav.addObject("userDetail", rankingService.findUserBetDetail(userId, userRank));
        return mav;
    }
}
