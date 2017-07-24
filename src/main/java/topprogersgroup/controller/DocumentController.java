package topprogersgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import topprogersgroup.entity.*;
import topprogersgroup.service.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by VP on 16.06.2017.
 */

@Controller
@RequestMapping("/docs")
public class DocumentController {


    //Возможные статусы REJECTED, CREATED, PROCESSED, ACCEPTED, APPROVED
    private final String BID_REJECTED = "REJECTED";//Отклонен
    private final String BID_PROCESSED = "PROCESSED";//Обрабатывается
    private final String BID_ACCEPTED = "ACCEPTED";//Принят
    private final String BID_APPROVED = "APPROVED";//Утвержден - значит оформлено вет. свидетельство
    private final String VET_DOC_NOT_SENT = "NOT_SENT";//Вет документ еще не отослан
    private final String VET_DOC_SENT = "SENT";//Вет документ отослан
    private final String VET_SERT_CREATED = "CREATED";
    private final String VET_SERT_SENT = "SENT";//Отправлен
    private final String VET_SERT_REJECTED = "REJECTED";//Отклонен
    private final String VET_SERT_ACCEPTED = "ACCEPTED";//Принят

    @Autowired
    private VeterinaryDocumentService veterinaryDocService;

    @Autowired
    private BidService bidService;

    @Autowired
    private VeterinaryCertificateService veterinaryCertService;

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"","/home"}, method = RequestMethod.GET)
    public String home(Model model){
        return "document/home";
    }

    //Вывод всех заявок в состоянии ОБРАБАТЫВАЕТСЯ
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/{numberPage}"}, method = RequestMethod.GET)
    public String all(Model model,
                      @PathVariable Integer numberPage){
        if(numberPage < 0){
            numberPage = 0;
        }
        Pageable pageable = new PageRequest(numberPage,20);
        List<Bid> bidList = bidService.findForPageByStatusAndSortDate(BID_PROCESSED,false, pageable);
        model.addAttribute("bidList", bidList);
        model.addAttribute("numberPage",numberPage);
        return "document/bids";
    }

    //Поиск заявок по номеру документа Владельца(находятся на странице - findbids)
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/find/bids"}, method = RequestMethod.POST)
    public String findBid(Model model,
                          @RequestParam String ownerDocNumber){
        Set<Bid> bidList = bidService.findByDocumentNumberAndStatus(BID_PROCESSED,ownerDocNumber,false);
        model.addAttribute("bidList",bidList);
        return "document/forfindbids";
    }

    //Поиск принятых заявок по номеру документа Владельца(находятся на странице - findacceptedbids)
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/find/acceptedbids"}, method = RequestMethod.POST)
    public String findAcceptedBid(Model model,
                                  @RequestParam String ownerDocNumber){
        Set<Bid> bidList = bidService.findByDocumentNumberAndStatus(BID_ACCEPTED,ownerDocNumber,false);
        model.addAttribute("bidList",bidList);
        return "document/forfindbids";
    }

    //Выбранная заявка
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/bid/{idBid}"}, method = RequestMethod.GET)
    public String processBid(Model model,
                             @PathVariable Integer idBid){
        Bid bid = bidService.findOne(idBid);
        if(bid.getStatus().equals(BID_PROCESSED)){
            model.addAttribute("bid", bid);
            model.addAttribute("petList", bid.getPets());
            model.addAttribute("route", bid.getRoute());
            return "document/bid";//Страница с заявкой
        }
       return String.format("redirect:/docs/%d",0);
    }

    //Сохранения решения насчет заявки(ОТКЛОНЕНА или ПРИНЯТА)
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/bid/{idBid}"}, method = RequestMethod.POST)
    public String processBid(Model model,
                             @Valid @ModelAttribute("bid")Bid bid,
                             BindingResult bindingResult,
                             @PathVariable Integer idBid){
        Bid bid1 = bidService.findOne(idBid);
        if(bid.getStatus().equals(BID_REJECTED) ||
                bid.getStatus().equals(BID_ACCEPTED)){
            bid1.setStatus(bid.getStatus());
            bidService.save(bid1);
        }
        return  String.format("redirect:/docs/%d",0);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/accepted/page/{numberPage}"}, method = RequestMethod.GET)
    public String getAcceptedBidPage(Model model,
                                     @ModelAttribute("numberPage")Integer numberPage){
        if(numberPage < 0){
            numberPage = 0;
        }
        Pageable pageable = new PageRequest(numberPage,20);
        List<Bid> bidList = bidService.findForPageByStatusAndSortDate(BID_ACCEPTED,false,pageable);
        model.addAttribute("bidList", bidList);
        model.addAttribute("numberPage",numberPage);
        return "document/acceptedbids";
    }

    @Autowired
    CurrentUserService userService;

    @Autowired
    EmployeeService employeeService;

    //Создать Вет. Документ по Принятому БИДу
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/accepted/bid/{idBid}"}, method = RequestMethod.GET)
    public String createVetDocForAcceptedBid(Model model,
                                             @PathVariable Integer idBid){
        Bid bid = bidService.findOne(idBid);
        if(bid.getStatus().equals(BID_ACCEPTED)){
            VeterinaryDocument vetDoc = new VeterinaryDocument();
            vetDoc.setIssueDate(new Date());
            vetDoc.setBid(bid);
            List<SpecialNotes> notes = new ArrayList<>();
            SpecialNotes specialNote = new SpecialNotes();
            notes.add(specialNote);
            vetDoc.setSpecialNotes(notes);
            Employee employee = employeeService.findEmployeeByEmail(userService.getUserEmail(),false);
            vetDoc.setEmployee(employee);
            vetDoc.setStateVeterinaryService(employee.getStateVeterinaryService());
            model.addAttribute("vetDoc",vetDoc);
            model.addAttribute("bid", bid);
            return "document/vetdoc";
        }
        return String.format("redirect:/docs/accepted/page/%d",0);
    }

    //Создать Вет. Документ по Принятому БИДу
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/accepted/bid/{idBid}"}, method = RequestMethod.POST)
    public String createVetDocForAcceptedBid(Model model,
                                             @PathVariable Integer idBid,
                                             @ModelAttribute("specialNotes") ArrayList<SpecialNotes> specialNotes,
                                             @ModelAttribute("vetDoc") VeterinaryDocument vetDoc,
                                             BindingResult bindingVetDocResult){
        if(bindingVetDocResult.hasErrors()){
            return "document/vetdoc";
        }
        Bid bid = bidService.findOne(idBid);
        vetDoc.setBid(bid);
        vetDoc.setIssueDate(new Date());
        vetDoc.setStatus(VET_DOC_NOT_SENT);
        Employee employee = employeeService.findEmployeeByEmail(userService.getUserEmail(),false);
        vetDoc.setEmployee(employee);
        vetDoc.setStateVeterinaryService(employee.getStateVeterinaryService());
        vetDoc = veterinaryDocService.create(vetDoc);
        bid.setStatus(BID_APPROVED);
        return String.format("redirect:/docs/vet/doc/%d",vetDoc.getId());
    }

    //Список всех Вет. Документов
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/doc/page/{numberPage}"}, method = RequestMethod.GET)
    public String getVeterinaryDocumentList(Model model,
                                            @PathVariable Integer numberPage){
        if(numberPage < 0){
            numberPage = 0;
        }
        Pageable pageable = new PageRequest(numberPage,20);
        List<VeterinaryDocument> vetDocList = veterinaryDocService.getAllVeterinaryDocumentPagingList(pageable);
        model.addAttribute("vetDocList", vetDocList);
        model.addAttribute("numberPage", numberPage);
        return "document/vetdocs";
    }

    //Просмотреть Вет.Документ
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/doc/{idDoc}"}, method = RequestMethod.GET)
    public String previewVeterinaryDocument(Model model,
                                            @PathVariable Integer idDoc){
        VeterinaryDocument vetDoc = veterinaryDocService.getVeterinaryDocumentById(idDoc);
        Bid bid = vetDoc.getBid();
        model.addAttribute("vetDoc", vetDoc);
        model.addAttribute("bid", bid);
        model.addAttribute("petList", bid.getPets());
        model.addAttribute("route", bid.getRoute());
        return "document/previewvetdoc";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/doc/{idDoc}/send"}, method = RequestMethod.GET)
    public String createVeterinaryCertificate(Model model,
                                              @PathVariable Integer idDoc){
        VeterinaryCertificate vetSert = new VeterinaryCertificate();
        vetSert.setIssueDate(new Date());
        model.addAttribute("vetSert",vetSert);
        model.addAttribute("idDoc",idDoc);
        return "document/vetsert";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/doc/{idDoc}/send"}, method = RequestMethod.POST)
    public String createVeterinaryCertificate(Model model,
                                              @ModelAttribute("vetSert") VeterinaryCertificate vetSert,
                                              BindingResult bindingResult,
                                              @PathVariable Integer idDoc){
        if(bindingResult.hasErrors()){
            return "document/vetsert";
        }
        VeterinaryDocument vetDoc = veterinaryDocService.getVeterinaryDocumentById(idDoc);
        vetSert.setVeterinaryDocument(vetDoc);
        vetSert.setStatus(VET_SERT_CREATED);
        vetSert.setIssueDate(new Date());
        veterinaryCertService.create(vetSert);
        vetDoc.setStatus(VET_DOC_SENT);
        veterinaryDocService.edit(vetDoc);
        return "redirect:/docs/accepted/page/1";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/sert/page/{numberPage}"}, method = RequestMethod.GET)
    public String getVeterinaryCertificateList(Model model,
                                            @PathVariable Integer numberPage){
        if(numberPage <= 0){
            numberPage = 1;
        }
        Pageable pageable = new PageRequest(numberPage,20);
        List<VeterinaryCertificate> vetSertList = veterinaryCertService.findForPageBySortDate(false,pageable);
        model.addAttribute("vetSertList", vetSertList);
        model.addAttribute("numberPage", numberPage);
        return "document/vetserts";
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/sert/{idDoc}/send"}, method = RequestMethod.POST)
    public String sendDocumentToForeignCountry(@PathVariable Integer idDoc){
        VeterinaryCertificate vetSert = veterinaryCertService.findById(idDoc);
        vetSert.setStatus(VET_SERT_SENT);
        veterinaryCertService.edit(vetSert);
        veterinaryCertService.getStatusFromForeignSystem(vetSert);
        return "redirect:/docs/sert/page/1";
    }

    //Просмотреть Вет.сертификат
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value = {"/vet/sert/{idDoc}"}, method = RequestMethod.GET)
    public String previewVeterinaryCertificate(Model model,
                                            @PathVariable Integer idDoc){
        VeterinaryCertificate vetSert = veterinaryCertService.findById(idDoc);
        VeterinaryDocument vetDoc = vetSert.getVeterinaryDocument();
        Bid bid = vetDoc.getBid();
        model.addAttribute("vetSert", vetSert);
        model.addAttribute("vetDoc", vetDoc);
        model.addAttribute("bid", bid);
        model.addAttribute("petList", bid.getPets());
        model.addAttribute("route", bid.getRoute());
        return "document/previewvetsert";
    }
}
