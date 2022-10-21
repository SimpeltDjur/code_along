package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.enteties.AppUser;
import com.example.spring_thymeleaf.enteties.Todo;
import com.example.spring_thymeleaf.repo.AppUserRepo;
import com.example.spring_thymeleaf.repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final AppUserRepo appUserRepo;

    public TodoService(TodoRepo todoRepo, AppUserRepo appUserRepo) {
        this.todoRepo = todoRepo;
        this.appUserRepo = appUserRepo;
    }

    public List<Todo> findAll(String contains) {
        if(contains.isBlank())
            return todoRepo.findAll();

        return todoRepo.findTodosByTitleContainsIgnoreCase(contains);
    }

    public Todo findById(int id) {
        return todoRepo.findById(id).orElseThrow();
    }

    public Todo addTodo(String title, String description, int userId) {
        AppUser appUser = appUserRepo.findById(userId).orElseThrow();
        return todoRepo.save(new Todo(title, description, appUser));
    }

    public void deleteById(int id) {
        todoRepo.deleteById(id);
    }
}
