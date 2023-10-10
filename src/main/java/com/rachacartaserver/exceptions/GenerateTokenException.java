package com.rachacartaserver.exceptions;

import com.rachacartaserver.infra.configs.RuntimeExceptionConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.INTERNAL_SERVER_ERROR,
        reason = "Ocorreu erro ao gerar a token de autenticação, por favor tente mais tarde."
)
public class GenerateTokenException extends RuntimeExceptionConfiguration {
    public GenerateTokenException(){
        super();
    }
}
