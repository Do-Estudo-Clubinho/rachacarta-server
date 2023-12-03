package com.rachacartaserver.exceptions;

import com.rachacartaserver.infra.configs.RuntimeExceptionConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Access denied: Your token is invalid.")
public class InvalidTokenException extends RuntimeExceptionConfiguration {
    public InvalidTokenException(){
        super();
    }
}

