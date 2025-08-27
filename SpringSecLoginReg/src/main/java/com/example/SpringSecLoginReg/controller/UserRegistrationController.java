package com.example.SpringSecLoginReg.controller;

import com.example.SpringSecLoginReg.service.UserService;
import com.example.SpringSecLoginReg.web.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;

    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }
    // @GetMapping
    //public String showRegistartionForm(){
    //   return "registration";
    //
//}

    @GetMapping
    public String showRegistartionForm(
            @RequestParam(value = "success", required = false) String success,
            Model model) {
        if (success != null) {
            model.addAttribute("message", "Registration successful! You can now log in.");
        }
        return "registration";
    }


@PostMapping
 public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO){
     userService.save(userRegistrationDTO);
     return "redirect:/registration?success";

 }

}
