package com.rachacartaserver.controllers.v1;

import com.rachacartaserver.DTOs.RegisterDTO;
import com.rachacartaserver.documentations.controllers.v1.AuthDoc;
import com.rachacartaserver.domains.User.User;
import com.rachacartaserver.services.AuthorizationService;
import com.rachacartaserver.DTOs.LoginRequestDTO;
import com.rachacartaserver.DTOs.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/auth")
public class AuthController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private com.rachacartaserver.infra.adapters.JWTAdapter JWTAdapter;

    @AuthDoc.LoginDoc
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDTO  login (@RequestBody @Valid LoginRequestDTO body) {
        User user = this.authorizationService.login(body);
        String token = this.JWTAdapter.createUserToken(user);

        LoginResponseDTO response = new LoginResponseDTO(token, user);

        return response;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup (RegisterDTO body) {
        User user = this.authorizationService.register(body);

        return user;
    }
}
