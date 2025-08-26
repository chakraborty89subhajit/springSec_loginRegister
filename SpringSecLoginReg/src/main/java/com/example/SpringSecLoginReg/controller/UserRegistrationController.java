package com.example.SpringSecLoginReg.controller;

import com.example.SpringSecLoginReg.service.UserService;
import com.example.SpringSecLoginReg.web.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
 private UserService userService;
 public UserRegistrationController (UserService userService){
     super();
     this.userService=userService;

 }
 @ModelAttribute("user")
 public UserRegistrationDTO userRegistrationDTO(){
     return new UserRegistrationDTO();
 }
    @GetMapping
 public String showRegistartionForm(){
     return "registration";
 }
@PostMapping
 public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO){
     userService.save(userRegistrationDTO);
     return "redirect:/registration?success";

 }

}
