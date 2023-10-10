package com.rachacartaserver.documentations.exceptions;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ApiResponse(
        responseCode = "402",
        description = "",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = InvalidTokenDoc.class))
)
public @interface InvalidTokenDoc {
}
