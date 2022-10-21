package com.example.spring_thymeleaf;

import com.example.spring_thymeleaf.enteties.AppUser;
import com.example.spring_thymeleaf.enteties.Role;
import com.example.spring_thymeleaf.enteties.Todo;
import com.example.spring_thymeleaf.repo.AppUserRepo;
import com.example.spring_thymeleaf.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringThymeleafApplication implements CommandLineRunner {

    @Autowired
    TodoRepo todoRepo;

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            appUserRepo.save(new AppUser("Alice", passwordEncoder.encode("1234"), Set.of(Role.ADMIN)));
            AppUser appUser = appUserRepo.save(new AppUser("Gunnar", passwordEncoder.encode("1234"), Set.of(Role.USER)));
            todoRepo.saveAll(List.of(
                    new Todo("Min första todo", "Här finns något man borde göra", appUser),
                    new Todo("En till todo", "mer text", appUser)
            ));
            System.out.println(appUser.getPassword());
        } catch (DataIntegrityViolationException err){
            System.out.println(err.getMessage());
        }


    }
}
