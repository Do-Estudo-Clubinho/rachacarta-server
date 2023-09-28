package com.example.demo.domain.User;

public record SignupDTO (String login, String password, String name, UserRole role, String state, String city, String country) {

}
