package com.rachacartaserver.domains.User;

import com.rachacartaserver.DTOs.RegisterDTO;
import com.rachacartaserver.infra.adapters.BCryptAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {

  @Autowired
  BCryptAdapter bCryptAdapter;
  public User createUserByRegister (RegisterDTO register) {
    return new User(
            register.login(),
            register.nickName(),
            "CUSTUMER",
            bCryptAdapter.passwordEncoder(register.password()),
            register.state(),
            register.city(),
            register.country()
    );
  }
}
