package fr.valtech.bet.web;

import java.util.Date;
import java.util.List;

import fr.valtech.bet.service.match.MatchService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.match.dto.MatchDto;

@Controller
@RequestMapping("match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @RequestMapping
    public ModelAndView match() {
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        ModelAndView mav = new ModelAndView("match");

        List<Date> dates = getDates();
        mav.addObject("dates", dates);

        Date today = new DateTime().toDateMidnight().toDate();
        mav.addObject("today", today);

        List<MatchDto> dtos = matchService.findMatchsByDateByUser(today, username);
        mav.addObject("dtos", dtos);
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
        dto.setScore1(4);
        dto.setScore2(1);
        dtos.add(dto);
        dto = new MatchDto();
        dto.setOpponent1("Brezil");
        dto.setOpponent2("Croatie");
        dto.setScore1(3);
        dto.setScore2(0);
        dto.setBet1(3);
        dto.setBet2(1);
        dtos.add(dto);
        dto = new MatchDto();
        dto.setOpponent1("Espagne");
        dto.setOpponent2("Pays-bas");
        dto.setScore1(1);
        dto.setScore2(2);
        dtos.add(dto);
        return dtos;
    }
}
