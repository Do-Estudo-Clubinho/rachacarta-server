package com.example.demo.controllers;

import com.example.demo.domain.User.User;
import com.example.demo.domain.User.UserRequestDTO;
import com.example.demo.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("users")
public class UserController {

  @Autowired
  UserRepository repository;

  @PostMapping
  public ResponseEntity signup (@RequestBody @Valid UserRequestDTO body) {
    System.out.println("test");
    // User newUser = new User(body);

    // this.repository.save(newUser);

    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity listUser() {
      return ResponseEntity.ok("Deu bom");
  }


}