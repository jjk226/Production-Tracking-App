package com.eci.production.controller;

import com.eci.production.entity.Tool;
import com.eci.production.service.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eci.production.entity.Entry;
import com.eci.production.repository.EntryRepository;
import com.eci.production.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/tool")
public class ToolController {

    private ToolService toolService;

    @Autowired
    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/")
    public String showTools(Model model) {
        List<Tool> tools = toolService.findAll();
        List<Tool> sortedTools = tools.stream().sorted((e1, e2) -> e1.getSerialNumber() - e2.getSerialNumber()).collect(Collectors.toList());
        model.addAttribute("tools", sortedTools);
        return "tools";
    }

    @GetMapping("/add-tool")
    public String addTool(@ModelAttribute("tempTool") Tool tool, Model model) {
        model.addAttribute("tempTool", tool);
        return "add-tool";
    }

    @PostMapping("/save")
    public String saveTool(@ModelAttribute("tempTool") Tool tool) {
        toolService.saveTool(tool);
        return "redirect:/tool/";
    }

    @GetMapping("/update")
    public String updateTool(@RequestParam int id, Model model, HttpServletRequest request) {
        Tool tool = toolService.findById(id);
        model.addAttribute("tool", tool);
        model.addAttribute("entries", tool.getEntries());

        return "update-tool";
    }

    @GetMapping("/add-entry")
    public String addNewEntry(@RequestParam int id, Model model) {
        Entry entry = new Entry();
        Tool tool = toolService.findById(id);

        entry.setTool(tool);
        entry.setSerialNumber(tool.getSerialNumber());
        entry.setStatus("OPEN");
        entry.setStartDate(new Date());

        tool.addEntry(entry);
        toolService.saveTool(tool);

        return "redirect:/tool/update?id=" + id;
    }

    @GetMapping("find")
    public String findBySerialNumber(
            @RequestParam String searchCriteria,
            @RequestParam String searchTerm,
            Model model) {
        if (searchCriteria.equals("serialNumber")) {
            List<Tool> tools = toolService.findBySerialNumber(Integer.valueOf(searchTerm));
            model.addAttribute("tools", tools);
        }

        return "tools";
    }

}
