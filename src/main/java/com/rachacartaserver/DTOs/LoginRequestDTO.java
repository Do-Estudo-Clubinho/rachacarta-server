package com.rachacartaserver.DTOs;

import io.swagger.v3.oas.annotations.responses.ApiResponse;


public record LoginRequestDTO(String login, String password) {}
