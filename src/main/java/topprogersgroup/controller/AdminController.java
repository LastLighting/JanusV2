package topprogersgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import topprogersgroup.entity.*;
import topprogersgroup.service.*;
import topprogersgroup.validator.UserCreateFormValidator;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StateVeterinaryServiceService stateVeterinaryServService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    private CheckPointService checkPointService;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"", "/", "/home"})
    public String getAdminHomePage() {
        return "admin/home";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        Employee e = new Employee();
        List<StateVeterinaryService> SVSList = stateVeterinaryServService.findAllIsNotDeleted();
        e.setEmploymentDate(new Date());
        Integer SVSId = null;
        modelAndView.setViewName("admin/user_create");
        modelAndView.addObject("form", new UserCreateForm());
        modelAndView.addObject("admin", new Administrator());
        modelAndView.addObject("SVSId",SVSId);
        modelAndView.addObject("employee", e);
        modelAndView.addObject("SVSList", SVSList);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String handleUserCreateForm(Model model,
                                       @Valid @ModelAttribute("form") UserCreateForm form,
                                       BindingResult bindingFormResult,
                                       @Valid @ModelAttribute("admin")Administrator admin,
                                       BindingResult bindingAdminResult,
                                       @Valid @ModelAttribute("employee")Employee employee,
                                       BindingResult bindingEmployeeResult,
                                       @ModelAttribute("SVSId")Integer SVSId){
        List<StateVeterinaryService> SVSList;
        if (bindingFormResult.hasErrors() || bindingAdminResult.hasErrors()) {
            SVSList = stateVeterinaryServService.findAllIsNotDeleted();
            model.addAttribute("SVSList", SVSList);
            return "admin/user_create";
        }
        User usr;
        try {
            usr = userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingFormResult.reject("email.exists", "Адрес электронной почты уже существует");
            return "admin/user_create";
        }
        if(form.getRole().equals(Role.ADMIN)) {
            admin.setUser(usr);
            administratorService.create(admin);
        }
        else if(form.getRole().equals(Role.EMPLOYEE)) {
            if(bindingEmployeeResult.hasErrors()){
                SVSList = stateVeterinaryServService.findAllIsNotDeleted();
                model.addAttribute("SVSList", SVSList);
                return "admin/user_create";
            }
            employee.setStateVeterinaryService(stateVeterinaryServService.findOne(SVSId));
            employee.setUser(usr);
            employeeService.create(employee);
        }
        return "admin/home";
    }

    //Добавить ГосВетСлужбу
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/create"}, method = RequestMethod.GET)
    public String createSVetService(Model model){
        StateVeterinaryService service = new StateVeterinaryService();
        model.addAttribute("svService", service);
        return "admin/statevetservice";
    }

    //Добавить ГосВетСлужбу
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/create"}, method = RequestMethod.POST)
    public String createSVetService(Model model,
                                    @Valid @ModelAttribute("svService")StateVeterinaryService service,
                                    BindingResult result) {
        if(result.hasErrors()) {
            return "admin/statevetservice";
        }
        stateVeterinaryServService.create(service);
        return "admin/home";
    }

    //Вывести НЕ удаленные ГосВетСлужбы
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/list/normal"}, method = RequestMethod.GET)
    public String viewSVetServicesIsNotDel(Model model){
        List<StateVeterinaryService> servicesIsNotDel = stateVeterinaryServService.findAllIsNotDeleted();
        model.addAttribute("svServiceList", servicesIsNotDel);
        return "admin/allstatevetservice";
    }

    //Вывести удаленные ГосВетСлужбы
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/list/del"}, method = RequestMethod.GET)
    public String viewSVetServicesIsDel(Model model){
        List<StateVeterinaryService> servicesIsDel = stateVeterinaryServService.findAllIsDeleted();
        model.addAttribute("svServiceList", servicesIsDel);
        return "admin/alldeletestatevetservice";
    }

    //Удаление ГосВетСлужбы
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/list/{idSVS}/delete"}, method = RequestMethod.GET)
    public String deleteSVetServices(@PathVariable Integer idSVS){
        StateVeterinaryService svService = stateVeterinaryServService.findOne(idSVS);
        if(svService!= null && !svService.isDeleted()){
            stateVeterinaryServService.delete(svService);
        }
        return "redirect:/admin/vet/list/normal";
    }

    //Восстановление ГосВетСлужбы
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/list/{idSVS}/restore"}, method = RequestMethod.GET)
    public String restoreSVetServices(@PathVariable Integer idSVS){
        StateVeterinaryService svService = stateVeterinaryServService.findOne(idSVS);
        if(svService!= null && svService.isDeleted()){
            svService.setDeleted(false);
            stateVeterinaryServService.create(svService);
        }
        return "redirect:/admin/vet/list/del";
    }

    //Редактирование ГосВетСлужбы
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/list/{idSVS}/edit"}, method = RequestMethod.GET)
    public String editVetServices(Model model,
                                 @PathVariable Integer idSVS){
        StateVeterinaryService svService = stateVeterinaryServService.findOne(idSVS);
        if(svService!= null && !svService.isDeleted()){
            model.addAttribute("svService", svService);
            return "admin/statevetservice";
        }
        return "redirect:/admin/vet/list/normal";
    }

    //Редактирование ГосВетСлужбы
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/vet/list/{idSVS}/edit"}, method = RequestMethod.POST)
    public String editVetServices(@Valid @ModelAttribute("svService")StateVeterinaryService service,
                                  BindingResult result) {
        if(result.hasErrors()) {
            return "admin/statevetservice";
        }
        stateVeterinaryServService.create(service);
        return "admin/home";
    }

    //Добавить пропускной пунк (ПКВП)
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/create"}, method = RequestMethod.GET)
    public String createCheckPoint(Model model){
        CheckPoint checkPoint = new CheckPoint();
        model.addAttribute("checkPoint", checkPoint);
        return "admin/checkpoint";
    }

    //Добавить пропускной пунк (ПКВП)
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/create"}, method = RequestMethod.POST)
    public String createCheckPoint(Model model,
                                   @Valid @ModelAttribute("checkPoint")CheckPoint checkPoint,
                                   BindingResult result){
        if(result.hasErrors()){
            return "admin/checkpoint";
        }
        checkPointService.save(checkPoint);
        return "admin/home";
    }

    //Вывести НЕ удаленные ПКВП
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/list/normal"}, method = RequestMethod.GET)
    public String viewCheckPointIsNotDel(Model model){
        List<CheckPoint> checkPointListIsNotDel = checkPointService.findAllIsNotDeleted();
        model.addAttribute("checkPointList", checkPointListIsNotDel);
        return "admin/allcheckpoint";
    }

    //Вывести удаленные ПКВП
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/list/del"}, method = RequestMethod.GET)
    public String viewCheckPointIsDel(Model model){
        List<CheckPoint> checkPointListIsDel = checkPointService.findAllIsDeleted();
        model.addAttribute("checkPointList", checkPointListIsDel);
        return "admin/alldeletecheckpoint";
    }

    //Удаление ПКВП
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/list/{idCheckPoint}/delete"}, method = RequestMethod.GET)
    public String deleteCheckPoint(@PathVariable Integer idCheckPoint){
        CheckPoint checkPoint = checkPointService.findOne(idCheckPoint);
        if(!checkPoint.isDeleted()){
            checkPointService.delete(checkPoint);
        }
        return "redirect:/admin/checkpoint/list/normal";
    }

    //Восстановление ПКВП
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/list/{idCheckPoint}/restore"}, method = RequestMethod.GET)
    public String restoreCheckPoint(@PathVariable Integer idCheckPoint){
        CheckPoint checkPoint = checkPointService.findOne(idCheckPoint);
        if(checkPoint.isDeleted()){
            checkPoint.setDeleted(false);
            checkPointService.save(checkPoint);
        }
        return "redirect:/admin/checkpoint/list/del";
    }

    //Редактирование ПКВП
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/list/{idCheckPoint}/edit"}, method = RequestMethod.GET)
    public String editCheckPoint(Model model,
                                   @PathVariable Integer idCheckPoint){
        CheckPoint checkPoint = checkPointService.findOne(idCheckPoint);
        if(!checkPoint.isDeleted()){
            model.addAttribute("checkPoint", checkPoint);
            return "admin/checkpoint";
        }
        return "redirect:/admin/checkpoint/list/normal";
    }

    //Редактирование ПКВП
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = {"/checkpoint/list/{idCheckPoint}/edit"}, method = RequestMethod.POST)
    public String editCheckPoint(Model model,
                                 @Valid @ModelAttribute("checkPoint")CheckPoint checkPoint,
                                 BindingResult result){
        if(result.hasErrors()){
            return "admin/checkpoint";
        }
        checkPointService.save(checkPoint);
        return "redirect:/admin/checkpoint/list/normal";
    }

}
