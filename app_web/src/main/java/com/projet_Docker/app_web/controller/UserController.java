package com.projet_Docker.app_web.controller;

import com.projet_Docker.app_web.repository.UserRepository;
import com.projet_Docker.app_web.model.User ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/test")
    public String test() {
        return "L'application fonctionne";
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok("Bonjour %s %s!".formatted(user.getPrenom(), user.getNom())))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Validation des données
        if(user.getPrenom() == null || user.getNom() == null) {
            return ResponseEntity.badRequest().build();
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
