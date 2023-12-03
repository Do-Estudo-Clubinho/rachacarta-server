package com.rachacartaserver.exceptions;

import com.rachacartaserver.infra.configs.RuntimeExceptionConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.INTERNAL_SERVER_ERROR,
        reason = "Sorry, an internal server error occurred. Please try again later."
)
public class InternalException extends RuntimeExceptionConfiguration {
    public InternalException(){
        super();
    }
}
