package com.eci.production.controller;

import com.eci.production.entity.Entry;
import com.eci.production.repository.EntryRepository;
import com.eci.production.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/entry")
public class EntryController {

    private EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping(path="/save")
    public String saveNewEntry(@ModelAttribute("tempEntry") Entry entry, HttpServletRequest request) throws Exception {

        if (entry.getId() == 0) {
            this.createNewEntry(entry);
        }

        Entry savedEntry = entryService.findById(entry.getId());

        savedEntry.setProductionOrder(entry.getProductionOrder());
        savedEntry.setEmployeeId(entry.getEmployeeId());
        savedEntry.setOperation(entry.getOperation());
        String savedEntryStatus = savedEntry.getStatus();
        String entryStatus = entry.getStatus();

        if (savedEntryStatus.equals(entryStatus)) {
            entryService.save(savedEntry);
            return "redirect:/tool/update?id=" + savedEntry.getTool().getId();
        }

        savedEntry.setStatus(entryStatus);

        if (entryStatus.equals("CLOSED")) {
            savedEntry.setEndDate(new Date());
        } else if (entryStatus.equals("OPEN")) {
            savedEntry.setEndDate(null);
        }

        if (savedEntry.getSerialNumber() != 0) {
            entryService.save(savedEntry);

            return "redirect:/tool/update?id=" + savedEntry.getTool().getId();
        }

        entryService.save(savedEntry);

        return "redirect:/entry/entries";

    }

    public void createNewEntry(Entry entry) {
        entry.setStartDate(new Date());
        entry.setStatus("OPEN");
        entryService.save(entry);
    }

    @GetMapping("/add-form")
    public String addForm(@ModelAttribute("tempEntry") Entry entry, Model model) {
        model.addAttribute("tempEntry", entry);

        return "add-form";
    }

    @GetMapping(path="/all")
    @ResponseBody
    public List<Entry> findAllEntries() {
        List<Entry> entries = entryService.findAll();
        return entries;
    }

    @GetMapping(path="/find")
    public String findByProductionOrder(@RequestParam("searchTerm") String searchTerm, @RequestParam("searchCriteria")
            String searchCriteria,Model model, Error error ) {

        System.out.println(searchCriteria);
//        int productionOrder = entry.getProductionOrder();
//        List<Entry> entries = entryService.findByProductionOrder(productionOrder);
//        model.addAttribute("entries", entries);

//        if (searchCriteria.equals("productionOrder")) {
//            List<Entry> entries = entryService.findByProductionOrder(Integer.valueOf(searchTerm));
//            System.out.println(searchTerm);
//            model.addAttribute("entries", entries);
//
//            return "entries";
//        }

        switch(searchCriteria) {
            case "productionOrder" :
                List<Entry> entries = entryService.findByProductionOrder(Integer.valueOf(searchTerm));
                model.addAttribute("entries", entries);
                return "entries";
            case "employeeId" :
                List<Entry> entriesByEmployeeId = entryService.findByEmployeeId(Integer.valueOf(searchTerm));
                model.addAttribute("entries", entriesByEmployeeId);
                return "entries";
        }
        return "redirect:/entry/entries";
    }

    @GetMapping(path="/findByEmployeeId")
    @ResponseBody
    public List<Entry> getEntriesByEmployeeId(@RequestParam("employeeId") int employeeId) {
        return entryService.findByEmployeeId(employeeId);
    }

    @GetMapping(path="/update")
    public String update(@RequestParam("id") int id, Model model) {
        Entry entry = entryService.findById(id);
        model.addAttribute("tempEntry", entry);

        return "update-entry";
    }

    @GetMapping(path="/delete")
    public String delete(@RequestParam("entryId") int entryId, @RequestParam("toolId") int toolId) {
        Entry entryToDelete = entryService.findById(entryId);
        System.out.println("entry to delete: " + entryToDelete);
        entryService.delete(entryToDelete);

        return "redirect:/tool/update?id=" + toolId;
    }


    @GetMapping(path="/entries")
    public String listAll(@ModelAttribute("tempEntry") Entry entry, Model model) {

        List<Entry> entries = this.entryService.findAll();
        Collections.sort(entries, (e1, e2) -> e1.getProductionOrder() - e2.getProductionOrder());

        model.addAttribute("entries", entries);

        return "entries";
    }

}
