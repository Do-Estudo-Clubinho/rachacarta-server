package com.rachacartaserver.models.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity(name = "users")
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String nickName;
    private String state;
    private String city;
    private String country;
    private String role;
    private String password;

    public User(
            String login,
            String nickName,
            String role,
            String password,
            String state,
            String city,
            String country
    ) {
        this.login = login;
        this.nickName = nickName;
        this.role = role;
        this.password = password;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s']",
                this.id, this.nickName
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(UserLevel.retrieveByLevel(this.level)));
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.nickName;
    }

    @Override
    public boolean isAccountNonExpired() {

        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
