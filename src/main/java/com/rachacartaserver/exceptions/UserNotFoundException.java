package com.rachacartaserver.exceptions;

import com.rachacartaserver.infra.configs.RuntimeExceptionConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserNotFoundException extends RuntimeExceptionConfiguration {
    public UserNotFoundException() {
        super();
    }
}
