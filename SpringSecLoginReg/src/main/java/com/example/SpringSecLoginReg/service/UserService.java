package com.example.SpringSecLoginReg.service;

import com.example.SpringSecLoginReg.entity.Users;
import com.example.SpringSecLoginReg.web.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {
    Users save(
    UserRegistrationDTO registrationDTO);
}
