package com.rachacartaserver.documentations.controllers.v1;

import com.rachacartaserver.documentations.exceptions.InvalidPasswordDoc;
import com.rachacartaserver.DTOs.LoginResponseDTO;
import com.rachacartaserver.documentations.exceptions.GenerateTokenDoc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthDoc {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(summary = "Autenticar usuário", description = "Gera uma token de autenticação")
    @ApiResponse(
            responseCode = "201",
            description = "Retorno da autenticação",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponseDTO.class))
    )
    @InvalidPasswordDoc
    @GenerateTokenDoc
    static @interface LoginDoc {}
}
