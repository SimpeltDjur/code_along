package com.example.spring_thymeleaf.controller;

import com.example.spring_thymeleaf.enteties.AppUser;
import com.example.spring_thymeleaf.dto.AppUserResponseDTO;
import com.example.spring_thymeleaf.enteties.Todo;
import com.example.spring_thymeleaf.dto.TodoResponseDTO;
import com.example.spring_thymeleaf.security.AuthService;
import com.example.spring_thymeleaf.service.AppUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
//@Secured("ROLE_USER")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class AppUserController {

    private  final AppUserService appUserService;
    private final AuthService authService;

    public AppUserController(AppUserService appUserService, AuthService authService) {
        this.appUserService = appUserService;
        this.authService = authService;
    }

    @GetMapping
    public List<AppUserResponseDTO> findAllUsers() {
        return appUserService.findAll()
                .stream()
                .map(AppUser::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}/todo")
    //@PreAuthorize("@authService.idMatchesUser(#userId)")
    public List<TodoResponseDTO> findUserTodos(@PathVariable("id") int userId){
        return appUserService.findUserTodos(userId)
                .stream()
                .map(Todo::toResponseDTO)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        appUserService.deleteById(id);
    }

}
