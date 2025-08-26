package com.example.SpringSecLoginReg.service;

import com.example.SpringSecLoginReg.Repo.UserRepo;
import com.example.SpringSecLoginReg.entity.Role;
import com.example.SpringSecLoginReg.entity.Users;
import com.example.SpringSecLoginReg.web.dto.UserRegistrationDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

   // private UserRegistrationDTO registrationDTO;
    //constrauctor based dependamcy injection

    public UserServiceImpl (UserRepo userRepo){
        super();
        this.userRepo= userRepo;

    }

    public Users save(UserRegistrationDTO registrationDTO){
        Users user = new Users(
                registrationDTO.getFirst_name(),
                registrationDTO.getLast_name(),
                registrationDTO.getEmail(),
                registrationDTO.getPassword(),
                Arrays.asList(new Role("ROLE_USER"))
        );

return userRepo.save(user);
    }
}
