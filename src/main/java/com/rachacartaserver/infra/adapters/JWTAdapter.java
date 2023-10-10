package com.rachacartaserver.infra.adapters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rachacartaserver.exceptions.GenerateTokenException;
import com.rachacartaserver.infra.environments.SecurityEnvironment;
import com.rachacartaserver.exceptions.InvalidTokenException;
import com.rachacartaserver.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWTAdapter {
    @Autowired
    SecurityEnvironment securityEnvironment;

    String ISSUER = "racha-carta-server";

    public String createUserToken (User userAuthentication) throws GenerateTokenException {
        try {
            Algorithm algorithm = this.getAlgorithm();
            String token = JWT
                    .create()
                    .withIssuer(this.ISSUER)
                    .withSubject(userAuthentication.getUsername())
                    .sign(algorithm);

            return token;
        } catch (Exception error) {
            throw new GenerateTokenException();
        }
    }

    public String validarToken (String token) {
        try {
            Algorithm algorithm = this.getAlgorithm();
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception error) {
            throw new InvalidTokenException();
        }
    }

    private Algorithm getAlgorithm () {
        return Algorithm
                .HMAC256(this.securityEnvironment.getPrivateKey());
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(this.securityEnvironment.getExpirationInHours()).toInstant(ZoneOffset.of("-03:00"));
    }
}
