package com.todocode.demo.Controladores;

import com.todocode.demo.Entity.Users;
import com.todocode.demo.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    Users newUser(@RequestBody Users newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
