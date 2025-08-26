package com.example.SpringSecLoginReg.service;

import com.example.SpringSecLoginReg.entity.Users;
import com.example.SpringSecLoginReg.web.dto.UserRegistrationDTO;
import org.springframework.stereotype.Service;


public interface UserService {
    Users save(
    UserRegistrationDTO registrationDTO);
}
