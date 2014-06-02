package fr.valtech.bet.web.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.service.match.MatchService;
import fr.valtech.bet.service.score.CalculateScoreService;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private CalculateScoreService service;

    @Autowired
    private MatchService matchService;


    @RequestMapping
    public ModelAndView admin() {
        ModelAndView mav = new ModelAndView("admin/page");
        mav.addObject("matches", matchService.findMatches());
        return mav;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void saveMatches(@RequestBody List<Map<String,String>> dtos) {
        matchService.updateScoreMatch(dtos);
    }

    @RequestMapping("calculateTask")
    public void calculateTask(HttpServletResponse response) throws IOException {
        service.calculateScore();
        response.sendRedirect("/bet/admin");
    }
}
