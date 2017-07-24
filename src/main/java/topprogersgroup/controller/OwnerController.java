package topprogersgroup.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import topprogersgroup.entity.Owner;

@Controller
@RequestMapping(value = "/owner")
public class OwnerController  {

//    private static final String PATH = "/error";
//
//    @RequestMapping(value = PATH)
//    public String error() {
//        return "Error handling";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String editOwner(Model model){

        return "allOwner";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String editOwner(Model model, @ModelAttribute("owner") Owner owner){

        return "allOwner";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addOwner(Model model){
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "allOwner";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addOwner(Model model, @ModelAttribute("owner") Owner owner){

        return "allOwner";
    }
}
