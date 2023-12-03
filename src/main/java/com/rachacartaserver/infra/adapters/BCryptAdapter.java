package com.rachacartaserver.infra.adapters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
public class BCryptAdapter {

  private final int levelEncryptionStrength = 10;

  public Boolean passwordCompare(String password, String enteredPassword) {
    return BCrypt.checkpw(enteredPassword, password);
  }

  public String passwordEncoder(String password) {
    return new BCryptPasswordEncoder().encode(password);
  }
}