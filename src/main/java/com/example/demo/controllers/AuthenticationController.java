package com.example.demo.controllers;

import com.example.demo.domain.User.AuthenticationDTO;
import com.example.demo.domain.User.SignupDTO;
import com.example.demo.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserRepository userRepository;
  @PostMapping("/login")
  public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data)  {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var auth = this.authenticationManager.authenticate(usernamePassword);

    return ResponseEntity.ok().build();
  }

  @PostMapping("/signup")
  public ResponseEntity signup (@RequestBody @Valid SignupDTO data)  {
    UserDetails user = this.userRepository.findByLogin(data.login());
    if (!(user != null)) {

    }
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var auth = this.authenticationManager.authenticate(usernamePassword);

    return ResponseEntity.ok().build();
  }
 }
