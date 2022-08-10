package com.eci.production.controller;

import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;
import com.eci.production.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/subassembly")
public class SubassemblyController {

    private ToolService toolService;

    @Autowired
    public SubassemblyController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/")
    public String findAllSubassemblies(Model model) {
        List<Tool> ToolList = toolService.findAll().stream().filter(tool -> tool.isSubassembly()).collect(Collectors.toList());
        model.addAttribute("subassemblies", ToolList);

        return "subassemblies";
    }

    @GetMapping("/add")
    public String addTool(@ModelAttribute("tempSubassembly") Tool tempSubassembly, Model model) {
        model.addAttribute("tempSubassembly", tempSubassembly);

        return "add-subassembly";
    }

    @PostMapping("/save")
    public String saveTool(@ModelAttribute("tempSubassembly") Tool tempSubassembly) {
        tempSubassembly.setIsSubassembly(true);
        toolService.saveTool(tempSubassembly);

        return "redirect:/subassembly/";
    }

    @GetMapping("/update")
    public String updateTool(@RequestParam("id") int toolId, Model model) {
        Tool subassembly = toolService.findById(toolId);

        model.addAttribute("subassembly", subassembly);
        model.addAttribute("entries", subassembly.getEntries());

        return "update-subassembly";
    }

    @GetMapping("/add-entry")
    public String addEntry(@RequestParam("id") int id, Model model) {
        Tool subassembly = toolService.findById(id);

        Entry entry = new Entry();
        entry.setTool(subassembly);
        entry.setStartDate(new Date());
        entry.setStatus("OPEN");
        entry.setSerialNumber(subassembly.getSerialNumber());
        entry.setProductionOrder(subassembly.getProductionOrder());

        subassembly.addEntry(entry);
        toolService.saveTool(subassembly);

        return "redirect:/subassembly/update?id=" + id;

    }

    @GetMapping("/find")
    public String findByCriteria(@RequestParam("searchCriteria") String searchCriteria,
                                 @RequestParam("searchTerm") String searchTerm,
                                 Model model) {

        List<Tool> subassemblies = new ArrayList<>();
        switch(searchCriteria) {
            case "productionOrder" :
                subassemblies = toolService.findByProductionOrder(Integer.valueOf(searchTerm));
                break;
            case "partNumber" :
                subassemblies = toolService.findByPartNumber(searchTerm);
                break;
        }
        model.addAttribute("subassemblies", subassemblies);

        return "subassemblies";
    }
}
