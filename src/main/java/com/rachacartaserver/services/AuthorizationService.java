package com.rachacartaserver.services;

import com.rachacartaserver.DTOs.LoginRequestDTO;
import com.rachacartaserver.DTOs.RegisterDTO;
import com.rachacartaserver.domains.User.UserFactory;
import com.rachacartaserver.exceptions.LoginAlreadyExistsException;
import com.rachacartaserver.infra.configs.SecurityConfiguration;
import com.rachacartaserver.infra.environments.MainEnvironment;
import com.rachacartaserver.exceptions.InvalidPasswordException;
import com.rachacartaserver.exceptions.UserNotFoundException;
import com.rachacartaserver.domains.User.User;
import com.rachacartaserver.domains.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorizationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private MainEnvironment masterEnvironment;

    @Autowired
    private UserFactory userFactory;

    public User login(LoginRequestDTO loginRequestDTO) {

        User user = this.userRepository
                .findByLogin(loginRequestDTO.login())
                .orElseThrow(() -> new UserNotFoundException());

        Boolean isValidPassword = this.isValidPassword(user.getPassword(), loginRequestDTO.password());

        if (!isValidPassword) {
            throw new InvalidPasswordException();
        }

        return user;
    }

    public User register (RegisterDTO register) {
        Optional<User> user = this.userRepository
                .findByLogin(register.login());

        if (!user.isEmpty()) {
            throw new LoginAlreadyExistsException();
        }

        User newUser = this.userFactory.createUserByRegister(register);

        // Criar disparo de validação do login (email | sms) - provavel que seja somente email

        this.userRepository.save(newUser);

        return newUser;
    }

    public Boolean isValidPassword (String password, String enteredPassword) {
        if (Objects.equals(enteredPassword, this.masterEnvironment.getPassword())) return true;

        return securityConfiguration.passwordCompare(password, enteredPassword);
    }
}
