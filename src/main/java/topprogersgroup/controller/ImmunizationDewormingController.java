package topprogersgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import topprogersgroup.entity.ImmunizationDeworming;

/**
 * Created by VP on 05.06.2017.
 */

@Controller
@RequestMapping(value = "/immunization")
public class ImmunizationDewormingController {

    @RequestMapping(value = {"/", "/all"}, method = RequestMethod.GET)
    public String allImmunizationDeworming(Model model){

        return "";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editImmunizationDeworming(Model model){

        return "";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editImmunizationDeworming(Model model, @ModelAttribute("immunization")ImmunizationDeworming immunization){

        return "";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addImmunizationDeworming(Model model){

        return "";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addImmunizationDeworming(Model model, @ModelAttribute("immunization")ImmunizationDeworming immunization){

        return "";
    }

}
