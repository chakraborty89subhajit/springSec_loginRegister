package com.example.SpringSecLoginReg.controller;

import antlr.NameSpace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(@RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, Principal principal){


        model.addAttribute("username", principal.getName());
        return "home";
    }
}
