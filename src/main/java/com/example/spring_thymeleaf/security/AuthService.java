package com.example.spring_thymeleaf.security;

import com.example.spring_thymeleaf.enteties.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public static boolean idMatchesUser(int id){

        AppUser appUser = (AppUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return appUser.getId() == id;

    }

}
