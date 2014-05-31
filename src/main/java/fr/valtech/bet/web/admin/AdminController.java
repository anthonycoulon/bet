package fr.valtech.bet.web.admin;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import fr.valtech.bet.service.score.CalculateScoreService;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private CalculateScoreService service;

    @RequestMapping
    public ModelAndView admin() {
        return new ModelAndView("admin/page");
    }

    @RequestMapping("calculateTask")
    public void calculateTask(HttpServletResponse response) throws IOException {
        service.calculateScore();
        response.sendRedirect("/bet/admin");
    }
}
