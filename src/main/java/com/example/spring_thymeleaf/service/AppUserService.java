package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.enteties.AppUser;
import com.example.spring_thymeleaf.enteties.Todo;
import com.example.spring_thymeleaf.repo.AppUserRepo;
import com.example.spring_thymeleaf.repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {


    private final AppUserRepo appUserRepo;
    private final TodoRepo todoRepo;

    public AppUserService(AppUserRepo appUserRepo, TodoRepo todoRepo) {
        this.appUserRepo = appUserRepo;
        this.todoRepo = todoRepo;
    }

    public List<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    public List<Todo> findUserTodos(int userId) {
        // AppUser appUser = appUserRepo.findById(userId).orElseThrow();
           return todoRepo.findTodosByAppUser_Id(userId);

    }

    public void deleteById(int id) {
        appUserRepo.deleteById(id);
    }
}
