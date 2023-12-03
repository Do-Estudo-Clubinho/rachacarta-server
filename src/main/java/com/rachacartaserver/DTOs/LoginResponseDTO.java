package com.rachacartaserver.DTOs;

import com.rachacartaserver.domains.User.User;

public record LoginResponseDTO (String token, User user) {
}
