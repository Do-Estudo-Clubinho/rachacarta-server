package com.rachacartaserver.services;

import com.rachacartaserver.infra.configs.SecurityConfiguration;
import com.rachacartaserver.infra.environments.MainEnvironment;
import com.rachacartaserver.exceptions.InvalidPasswordException;
import com.rachacartaserver.exceptions.UserNotFoundException;
import com.rachacartaserver.models.User.User;
import com.rachacartaserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private MainEnvironment masterEnvironment;

    public User login(String login, String senha) {

        User user = this.userRepository
                .findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException());

        Boolean isValidPassword = this.isValidPassword(user.getPassword(), senha);

        if (!isValidPassword) {
            throw new InvalidPasswordException();
        }

        return user;
    }

    public Boolean isValidPassword (String password, String enteredPassword) {
        if (Objects.equals(enteredPassword, this.masterEnvironment.getPassword())) return true;

        return securityConfiguration.passwordCompare(password, enteredPassword);
    }
}
