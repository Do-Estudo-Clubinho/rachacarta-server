package com.example.demo.domain.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        String login,

        @NotBlank
        String password
        ) {
}
