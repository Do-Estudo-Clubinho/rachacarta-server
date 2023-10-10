package com.rachacartaserver.documentations.exceptions;

import com.rachacartaserver.exceptions.InvalidPasswordException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@ApiResponse(
        responseCode = "401",
        description = "Retorno senha inválida",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = InvalidPasswordException.class))
)
public @interface InvalidPasswordDoc {
}
