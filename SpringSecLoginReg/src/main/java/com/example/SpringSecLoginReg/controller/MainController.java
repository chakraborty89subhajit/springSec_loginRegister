package com.example.SpringSecLoginReg.controller;

import org.springframework.security.core.Authentication;
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
        return "login"; // your login.html
    }

    // 👇 this is called after login
   

    // Example admin page
    @GetMapping("/admin/home")
    public String adminHome(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "admin-home"; // view: admin-home.html
    }

    // Example user page
    @GetMapping("/user/home")
    public String userHome(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "user-home"; // view: user-home.html
    }
}
