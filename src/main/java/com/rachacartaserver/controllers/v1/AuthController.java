package com.rachacartaserver.controllers.v1;

import com.rachacartaserver.documentations.controllers.v1.AuthDoc;
import com.rachacartaserver.models.User.User;
import com.rachacartaserver.services.AuthenticationService;
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
    private AuthenticationService authenticationService;

    @Autowired
    private com.rachacartaserver.infra.adapters.JWTAdapter JWTAdapter;

    @AuthDoc.LoginDoc
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDTO  login (@RequestBody @Valid LoginRequestDTO body) {
        User user = this.authenticationService.login(body.login(), body.senha());
        String token = this.JWTAdapter.createUserToken(user);

        LoginResponseDTO response = new LoginResponseDTO(token, user);

        return response;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup () {
        return ResponseEntity.ok("response");
    }
}
