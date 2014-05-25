package fr.valtech.bet.web;

import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
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
        String username = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userService.findUser(username);

        ModelAndView mav = new ModelAndView("match");

        List<Date> dates = getDates();
        mav.addObject("dates", dates);

        Date date = new DateTime().toDateMidnight().toDate();
        mav.addObject("today", date);

        mav.addObject("dtos", matchService.findMatchByDateByUser(date, user));
        return mav;
    }

    private List<Date> getDates() {
        List<Date> dates = Lists.newArrayList();
        DateTime d = new DateTime(2014, 5, 20, 0, 0, 0);
        dates.add(d.toDate());
        d = d.plusDays(1);
        dates.add(d.toDate());
        d = d.plusDays(1);
        dates.add(d.toDate());
        d = d.plusDays(1);
        dates.add(d.toDate());
        d = d.plusDays(1);
        dates.add(d.toDate());
        return dates;
    }

    private List<MatchDto> getMatchDtos() {
        List<MatchDto> dtos = Lists.newArrayList();
        MatchDto dto = new MatchDto();
        dto.setOpponent1("France");
        dto.setOpponent2("Suisse");
        dto.setScore("4-1");
        dtos.add(dto);
        dto = new MatchDto();
        dto.setOpponent1("Brezil");
        dto.setOpponent2("Croatie");
        dto.setScore("3-0");
        dto.setBet1(3);
        dto.setBet2(1);
        dtos.add(dto);
        dto = new MatchDto();
        dto.setOpponent1("Espagne");
        dto.setOpponent2("Pays-bas");
        dto.setScore("1-2");
        dtos.add(dto);
        return dtos;
    }
}
