package com.example.spring_thymeleaf.controller;

import com.example.spring_thymeleaf.dto.CreateTodoDTO;
import com.example.spring_thymeleaf.enteties.Todo;
import com.example.spring_thymeleaf.dto.TodoResponseDTO;
import com.example.spring_thymeleaf.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    // ?contains=
    @GetMapping
    public List<TodoResponseDTO> findAll(
            @RequestParam(required = false, defaultValue = "", name = "tcon") String contains
    ){
       return todoService.findAll(contains)
               .stream()
               .map(Todo::toResponseDTO)
               .toList();

    }

    @GetMapping("/{id}")
    public TodoResponseDTO findById(@PathVariable("id") int id){

        return todoService.findById(id).toResponseDTO();

    }

    @PostMapping
    public TodoResponseDTO addTodo(@RequestBody CreateTodoDTO createTodoDTO) {
        return todoService
                .addTodo(
                        createTodoDTO.title(),
                        createTodoDTO.description(),
                        createTodoDTO.userId()
                )
                .toResponseDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        todoService.deleteById(id);
    }


}
