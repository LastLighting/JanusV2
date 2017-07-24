package topprogersgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import topprogersgroup.entity.Quarantine;
import topprogersgroup.entity.StateVeterinaryService;
import topprogersgroup.service.CheckPointService;
import topprogersgroup.service.StateVeterinaryServiceService;

/**
 * Created by VP on 05.06.2017.
 */

@Controller
@RequestMapping(value = "/quarantine")
public class QuarantineController {

    @RequestMapping(value = {"/","/all"}, method = RequestMethod.GET)
    public String allQuarantine(Model model){
        return "";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editQuarantine(Model model){
        Quarantine quarantine = new Quarantine();//Получаем

        model.addAttribute("quarantine", quarantine);
        return "";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editQuarantine(Model model, @ModelAttribute("quarantine") Quarantine quarantine){

        model.addAttribute("quarantine", quarantine);
        return "";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addQuarantine(Model model){
        Quarantine quarantine = new Quarantine();
        model.addAttribute("quarantine", quarantine);
        return "";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addQuarantine(Model model, @ModelAttribute("quarantine") Quarantine quarantine){

        return "";
    }



}
