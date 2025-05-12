package com.williams.spring_auth_initializer.auth.service.interfaces;

import com.williams.spring_auth_initializer.auth.entities.User;
import com.williams.spring_auth_initializer.auth.entities.util.Role;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    Long count();

    User save(User user);

    void deleteById(Long id);

    List<User> findByRole(Role role);
}
