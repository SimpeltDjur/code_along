package com.example.spring_thymeleaf.dto;

public record TodoResponseDTO(
        int id,
        String title,
        String description,
        boolean done,
        int appUserId
    )   {
}
