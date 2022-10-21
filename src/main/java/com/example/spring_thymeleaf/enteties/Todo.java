package com.example.spring_thymeleaf.enteties;

import com.example.spring_thymeleaf.dto.TodoResponseDTO;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean done;

    @ManyToOne
    private AppUser appUser;

    public Todo(String title, String description, AppUser appUser) {
        this.title = title;
        this.description = description;
        this.done = false;
        this.appUser = appUser;
    }

    public Todo() {
    }

    public TodoResponseDTO toResponseDTO(){
        return new TodoResponseDTO(id, title, description, done, appUser.getId());
    }

    public int getId() {
        return id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
