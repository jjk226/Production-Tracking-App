package com.eci.production.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eci.production.entity.Entry;
import com.eci.production.repository.EntryRepository;
import com.eci.production.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    public MainController() {}

    @RequestMapping("/")
    public String home() {
        return "home";
    }

}
