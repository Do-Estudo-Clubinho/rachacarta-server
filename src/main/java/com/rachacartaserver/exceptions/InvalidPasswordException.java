package com.rachacartaserver.exceptions;

import com.rachacartaserver.infra.configs.RuntimeExceptionConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.UNAUTHORIZED,
        reason = "The credentials you provided is invalid. Please check your login/password and try again."
)
public class InvalidPasswordException extends RuntimeExceptionConfiguration {
    public InvalidPasswordException(){
        super();
    }
}
