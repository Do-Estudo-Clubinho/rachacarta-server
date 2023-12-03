package com.rachacartaserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Login already exists.")
public class LoginAlreadyExistsException extends RuntimeException {
}
