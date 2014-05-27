package fr.valtech.bet.web.match;

import java.util.Date;
import java.util.List;
import java.util.Map;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.service.match.MatchService;
import fr.valtech.bet.service.user.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView match() {

        ModelAndView mav = new ModelAndView("match");

        mav.addObject("dates", matchService.findDates());

        Date date = new DateTime().toDateMidnight().toDate();
        mav.addObject("today", date);

        mav.addObject("dtos", matchService.findMatchByDateByUser(date, getUser()));
        return mav;
    }

    @ResponseBody
    @RequestMapping("{date}")
    public List<MatchDto> matches(@PathVariable Long date) {
        return matchService.findMatchByDateByUser(new Date(date), getUser());
    }

    private User getUser() {
        String username = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return userService.findUser(username);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody List<Map<String, String>> dtos) {
        matchService.saveUserBets(matchService.transform(dtos), getUser());
    }
}
