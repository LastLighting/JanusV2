package topprogersgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import topprogersgroup.entity.Vaccination;

/**
 * Created by VP on 04.06.2017.
 */

@Controller
@RequestMapping(value = "/vaccination")
public class VaccinationController {

    @RequestMapping(value = {"/", "/all"}, method = RequestMethod.GET)
    public String allVaccination(Model model){

        return "";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String editVaccination(Model model){

        return "";
    }


    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String editVaccination(Model model, @ModelAttribute("vaccination")Vaccination vaccination){

        return "";
    }
    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addVaccination(Model model){
        Vaccination vaccination = new Vaccination();
        model.addAttribute("vaccination",vaccination);
        return "";
    }


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addVaccination(Model model, @ModelAttribute("vaccination")Vaccination vaccination){

        return "";
    }
}
