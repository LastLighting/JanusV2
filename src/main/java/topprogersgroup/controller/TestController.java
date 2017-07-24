package topprogersgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import topprogersgroup.entity.Quarantine;

import java.util.Optional;

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        Quarantine quarantine = new Quarantine();
        model.addAttribute("quarantine", quarantine);
        return "test";
    }

}
