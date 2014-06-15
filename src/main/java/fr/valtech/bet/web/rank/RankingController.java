package fr.valtech.bet.web.rank;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.base.Throwables;
import fr.valtech.bet.domain.model.user.User;
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
        mav.addObject("userId", userId);
        return mav;
    }

    @RequestMapping("user/detail/avatar/{userId}")
    public void userAvatar(HttpServletResponse response, @PathVariable Long userId) {
        User user = userService.findUserById(userId);
        response.setContentType(user.getContentType());
        try {
            FileCopyUtils.copy(user.getAvatar(), response.getOutputStream());
        } catch (IOException e) {
            Throwables.propagate(e);
        }
    }
}
