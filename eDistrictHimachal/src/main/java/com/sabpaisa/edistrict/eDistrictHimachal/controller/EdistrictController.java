package com.sabpaisa.edistrict.eDistrictHimachal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/edistrict")
public class EdistrictController {

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             Model model) {

        
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        
        model.addAttribute("name", name);
        model.addAttribute("email", email);

        return "show"; 
    }
}
