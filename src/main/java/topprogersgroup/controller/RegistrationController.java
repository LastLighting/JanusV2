package topprogersgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import topprogersgroup.entity.*;
import topprogersgroup.service.OwnerService;
import topprogersgroup.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private OwnerService ownerService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("form", new UserCreateForm());
        modelAndView.addObject("owner", new Owner());
        return modelAndView;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public String handleRegistrationFirstPage(Model model,
                                              @ModelAttribute("form") UserCreateForm form,
                                              BindingResult bindingUserResult,
                                              @ModelAttribute("owner")Owner owner,
                                              BindingResult bindingOwnerResult) {
        if (bindingUserResult.hasErrors() || bindingOwnerResult.hasErrors()) {
            return "/registration";
        }
        User user;
        try {
            form.setRole(Role.PET_OWNER);
            user = userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingUserResult.reject("email.exists", "Адрес электронной почты уже существует");
            return "/registration";
        }
        owner.setUser(user);
        ownerService.save(owner);
        return "home";
    }
}
