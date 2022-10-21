package com.example.spring_thymeleaf.repo;

import com.example.spring_thymeleaf.enteties.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findAppUsersByUsernameIgnoreCase(String username);

}
