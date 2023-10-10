package com.rachacartaserver.repositories;

import com.rachacartaserver.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByLogin(String login);
}
