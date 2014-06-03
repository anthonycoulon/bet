package fr.valtech.bet.web.match;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.match.dto.QuotesDto;
import fr.valtech.bet.service.match.MatchService;
import fr.valtech.bet.service.user.UserService;

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

        mav.addObject("dtos", matchService.findMatchByDateByUser(date, userService.getConnectedUser()));
        return mav;
    }

    @ResponseBody
    @RequestMapping("{date}")
    public List<MatchDto> matches(@PathVariable String date) {
        if("none".equals(date)) {
            return Lists.newArrayList();
        }
        return matchService.findMatchByDateByUser(new Date(Long.valueOf(date)), userService.getConnectedUser());
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public List<QuotesDto> save(@RequestBody List<Map<String, String>> dtos) {
        return matchService.saveUserBets(matchService.transform(dtos), userService.getConnectedUser());
    }
}
