package topprogersgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;;
import topprogersgroup.entity.*;
import topprogersgroup.service.*;
import topprogersgroup.validator.FileValidator;
import topprogersgroup.validator.ImmunizationDewormingValidator;
import topprogersgroup.validator.OwnerValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/fast")
public class FastController {

    @Autowired
    private PassportService passportService;

    @Autowired
    private FileValidator fileValidator;

    @Autowired
    private OwnerValidator ownerValidator;

    @Autowired
    private ImmunizationDewormingValidator dewormingValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private QuarantineService quarantineService;

    @Autowired
    private PetService petService;

    @Autowired
    private VaccinationService vaccinationService;

    @Autowired
    private DiseaseService diseaseService;

    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String fast(Model model) {
        Passport passport = new Passport();
        List<ImmunizationDeworming> immunizations = new ArrayList<>();
        immunizations.add(new ImmunizationDeworming());
        List<Vaccination> vaccinations = new ArrayList<>();
        vaccinations.add(new Vaccination());
        passport.setVaccination(vaccinations);
        passport.setImmunizationDeworming(immunizations);
        passport.setOwner(new Owner());
        List<Disease> diseases = new ArrayList<>();
        diseases.add(new Disease());
        Quarantine quarantine = new Quarantine();
        quarantine.setDiseases(diseases);
        model.addAttribute("passport", passport);
        model.addAttribute("quarantine", quarantine);
        return "fast/add";
    }

    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("passport") Passport passport, @RequestParam("images_p") MultipartFile[] images, @ModelAttribute("quarantine") Quarantine quarantine) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            Owner owner = ownerService.findOwnerByEmailUser(email);

            passport.setOwner(owner);
            passport = passportService.save(passport);
            for (MultipartFile image : images) {
                passportService.uploadPassportImage(image, passport);
            }

            quarantine = quarantineService.save(quarantine);
            for (Disease disease: quarantine.getDiseases()){
                disease.setQuarantine(quarantine);
                diseaseService.save(disease);
            }
            Pet pet = new Pet();
            pet.setOwner(owner);
            pet.setPassport(passport);
            pet.setQuarantine(quarantine);
            petService.save(pet);
        }
        return "office/home";
    }
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/edit/{idPet}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Integer idPet) {
        Pet pet = petService.findOne(idPet);
        Passport passport = pet.getPassport();
        Quarantine quarantine = pet.getQuarantine();
        model.addAttribute("quarantine",  quarantine);
        model.addAttribute("passport", passport);
        model.addAttribute("pet", pet);
        return "fast/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(Model model,  @ModelAttribute("pet") Pet pet, @ModelAttribute("passport") Passport passport, @RequestParam("images_p") MultipartFile[] images, @ModelAttribute("quarantine") Quarantine quarantine){
        passport = passportService.update(passport);
        for (MultipartFile image : images) {
            passportService.uploadPassportImage(image, passport);
        }
        pet.setPassport(passport);
        quarantine.setId(0);
        pet.setQuarantine(quarantine);
        pet = petService.update(pet);
        model.addAttribute("quarantine",  pet.getQuarantine());
        model.addAttribute("passport",pet.getPassport());
        return "redirect:/office/pets";
    }

}
