package topprogersgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import topprogersgroup.entity.*;
import topprogersgroup.service.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/office")
public class OfficeController {

    //Возможные статусы REJECTED, CREATED, PROCESSED, ACCEPTED, APPROVED

    private final String BID_CREATED = "CREATED";
    private final String BID_PROCESSED = "PROCESSED";
    private final String BID_REJECTED = "REJECTED";

    @Autowired
    CurrentUserService userService;
    @Autowired
    PetService petService;
    @Autowired
    RouteService routeService;
    @Autowired
    BidService bidService;
    @Autowired
    OwnerService ownerService;

    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "/office/home";
    }

    //Все петомцы
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public String getAllPetsPage(Model model,
                                 @AuthenticationPrincipal User user) {
        Owner owner = ownerService.findOwnerByEmailUser(userService.getUserEmail());
        List<Pet> pets = petService.findIsLastPetByOwner(owner.getId());
        model.addAttribute("pets", pets);
        return "/office/pets";
    }

    //Страница пета
    //Запретить смотреть чужих петов
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/pets/{idPet}", method = RequestMethod.GET)
    public String getPetPage(Model model,
                             @PathVariable Integer idPet) {
        Pet pet = petService.findOne(idPet);
        Owner owner = ownerService.findOwnerByEmailUser(userService.getUserEmail());
        if (checkPet(owner, pet)) {
            Passport passport = pet.getPassport();
            model.addAttribute("pet", pet);
            model.addAttribute("passport", passport);
            model.addAttribute("owner", passport.getOwner());
            model.addAttribute("vaccinationList", passport.getVaccination());
            model.addAttribute("immunizationList", passport.getImmunizationDeworming());
            model.addAttribute("quarantine", pet.getQuarantine());
            return "/office/pet";
        }
        return "redirect:/office/pets";
    }

    private boolean checkPet(Owner owner, Pet pet) {
        if (pet.getOwner().getId() == owner.getId()) {
            return true;
        }
        return false;
    }

    //Все заявки

    @RequestMapping(value = "/bids", method = RequestMethod.GET)
    public String getBidPage(Model model) {
        Set<Bid> bidList = bidService.findByEmailUser(userService.getUserEmail(),false);
        model.addAttribute("bidList", bidList);
        return "/office/bids";
    }

    //Просмотр заявки
    @RequestMapping(value = "/bids/{idBid}/preview", method = RequestMethod.GET)
    public String previewBid(Model model,
                             @PathVariable Integer idBid) {
        Bid bid = bidService.findOne(idBid);
        Owner owner = ownerService.findOwnerByEmailUser(userService.getUserEmail());
        if (checkBid(owner, bid)) {
            model.addAttribute("bid", bid);
            model.addAttribute("route", bid.getRoute());
            model.addAttribute("petList", bid.getPets());
            return "/office/bid";
        }
        return "redirect:/office/bids";
    }

    private boolean checkBid(Owner owner, Bid bid) {
        for (Pet pet: bid.getPets()) {
            if (pet.getOwner().getId() == owner.getId()) {
                return true;
            }
        }
        return false;
    }

    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/bids/create", method = RequestMethod.GET)
    public String createBid(Model model) {
        Route route = new Route();
        Bid bid = new Bid();
        bid.setPets(new ArrayList<>());
        Owner owner = ownerService.findOwnerByEmailUser(userService.getUserEmail());
        List<Pet> petList = petService.findIsLastPetByOwner(owner.getId());
        model.addAttribute("petList", petList);
        model.addAttribute("route", route);
        model.addAttribute("bid", bid);
        Integer[] pets = {};
        model.addAttribute("petsid[]", pets);
        return "/office/create";
    }

    //Заявка создается со статусом СОЗДАНО
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/bids/create", method = RequestMethod.POST)
    public String createBid(Model model,
                            @ModelAttribute("bid")Bid bid,
                            BindingResult bindingBidResult, @RequestParam(value ="petsid[]") Integer[] petsid /*@RequestParam(value = "pets") String pets*/) {
        if(bindingBidResult.hasErrors()){
            return "/bids/create";
        }
        Route route = routeService.create(bid.getRoute());
        bid.setRoute(route);
        bid.setStatus(BID_CREATED);
        List<Pet> pets = new ArrayList<>();
        for (Integer id: petsid) {
            pets.add(petService.findOne(id));
        }
        bid.setPets(pets);
        bidService.save(bid);
        return "redirect:/office/bids";
    }

    //Редактирование возможно если заявка СОЗДАНА или ОТКЛОНЕНА
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/bids/{idBid}/edit", method = RequestMethod.GET)
    public String editBid(Model model,
                          @PathVariable Integer idBid) {
        Bid bid = bidService.findOne(idBid);
        if (bid.getStatus().equals(BID_CREATED) ||
                bid.getStatus().equals(BID_REJECTED)) {
            Owner owner = ownerService.findOwnerByEmailUser(userService.getUserEmail());
            List<Pet> pets = owner.getPet();
            model.addAttribute("pets", pets);
            model.addAttribute("route", bid.getRoute());
            model.addAttribute("bid", bid);
            return "/office/create";
        }
        return "/office/bids";
    }

    //Если мы редактировали заявку со статусом ОТКЛОНЕНА,
    // то ей выставляется статус СОЗДАНА, и переставляется дата
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/bids/{idBid}/edit", method = RequestMethod.POST)
    public String editBid(Model model,
                          @Valid @ModelAttribute("route") Route route,
                          BindingResult bindingRouteResult,
                          @Valid @ModelAttribute("bid") Bid bid,
                          BindingResult bindingBidResult) {
        if (bindingBidResult.hasErrors() || bindingRouteResult.hasErrors()) {
            return "/bids/create";
        }
        if (bid.getStatus().equals(BID_REJECTED)) {
            bid.setStatus(BID_CREATED);
        }
        route = routeService.create(route);
        bid.setRoute(route);
        bidService.save(bid);
        return "redirect:/office/bids";
    }

    //Отправлять возможно заявки только в состоянии СОЗДАНА
    //В если приходит в состоянии ОТКЛОНЕНА, то перенаправляем на редактирование
    //В других состояниях перенаправляются на страницу, всех заявок
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = "/bids/{idBid}/send", method = RequestMethod.GET)
    public String sendBid(Model model,
                          @PathVariable Integer idBid) {
        Bid bid = bidService.findOne(idBid);
        if (bid.getStatus().equals(BID_CREATED)) {
            bid.setStatus(BID_PROCESSED);
            bidService.save(bid);
            return "redirect:/office/bids";
        } else if (bid.getStatus().equals(BID_REJECTED)) {
            return String.format("redirect:/office/bids/%d/edit", idBid);
        }
        return "redirect:/office/bids";
    }

    //Просмотреть Вет.Документ
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = {"/vet/doc/{idBid}"}, method = RequestMethod.GET)
    public String previewVeterinaryDocument(Model model,
                                            @PathVariable Integer idBid) {
        Bid findBid = bidService.findOne(idBid);
        if (findBid != null && findBid.getVeterinaryDocument() != null) {
            VeterinaryDocument vetDoc = findBid.getVeterinaryDocument();
            Bid bid = vetDoc.getBid();
            model.addAttribute("vetDoc", vetDoc);
            model.addAttribute("bid", bid);
            model.addAttribute("petList", bid.getPets());
            model.addAttribute("route", bid.getRoute());
            return "office/previewvetdoc";
        }
        return String.format("redirect:/office/bids/%d/preview", idBid);
    }

    //Просмотреть Вет.сертификат
    @PreAuthorize("hasAuthority('PET_OWNER')")
    @RequestMapping(value = {"/vet/sert/{idBid}"}, method = RequestMethod.GET)
    public String previewVeterinaryCertificate(Model model,
                                               @PathVariable Integer idBid) {
        Bid findBid = bidService.findOne(idBid);
        if (findBid != null && findBid.getVeterinaryDocument() != null
                && findBid.getVeterinaryDocument().getVeterinaryCertificate() != null) {
            VeterinaryCertificate vetSert = findBid.getVeterinaryDocument().getVeterinaryCertificate();
            VeterinaryDocument vetDoc = vetSert.getVeterinaryDocument();
            Bid bid = vetDoc.getBid();
            model.addAttribute("vetSert", vetSert);
            model.addAttribute("vetDoc", vetDoc);
            model.addAttribute("bid", bid);
            model.addAttribute("petList", bid.getPets());
            model.addAttribute("route", bid.getRoute());
            return "office/previewvetsert";
        }
        return String.format("redirect:/office/bids/%d/preview", idBid);
    }


}
