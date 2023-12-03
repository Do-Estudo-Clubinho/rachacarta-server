package com.rachacartaserver.DTOs;

public record RegisterDTO(
        String login,
        String password,
        String nickName,
        String state,
        String city,
        String country
        ) {
}
