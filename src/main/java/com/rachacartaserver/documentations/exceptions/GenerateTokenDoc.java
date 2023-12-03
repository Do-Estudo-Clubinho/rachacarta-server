package com.rachacartaserver.documentations.exceptions;

import com.rachacartaserver.exceptions.InternalException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@ApiResponse(
        responseCode = "500",
        description = "Retorno de erro interno ao gerar token",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = InternalException.class))
)
public @interface GenerateTokenDoc {
}
