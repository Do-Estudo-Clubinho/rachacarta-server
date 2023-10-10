package com.rachacartaserver.DTOs;

import com.rachacartaserver.models.User.User;

public record LoginResponseDTO (String token, User user) {
}
