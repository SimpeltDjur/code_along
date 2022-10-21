package com.example.spring_thymeleaf.repo;

import com.example.spring_thymeleaf.enteties.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

    List<Todo> findTodosByTitleContainsIgnoreCase(String contains);

    List<Todo> findTodosByAppUser_Id(int userId);

}
