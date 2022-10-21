package com.example.spring_thymeleaf.controller;

import com.example.spring_thymeleaf.dto.LoginRequestDTO;
import com.example.spring_thymeleaf.dto.WhoAmIDTO;
import com.example.spring_thymeleaf.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO){

        return loginService.login(loginRequestDTO.username(), loginRequestDTO.password());
    }

    @GetMapping("/whoami")
    public WhoAmIDTO whoAmI(@RequestParam String token){
        return loginService.whoami(token);
    }

}
