package topprogersgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(value = "/403")
    public String getAccessDeniedPage() {
        return "403";
    }
}
