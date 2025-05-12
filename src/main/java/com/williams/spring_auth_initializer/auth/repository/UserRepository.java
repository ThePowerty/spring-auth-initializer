package com.williams.spring_auth_initializer.auth.repository;

import com.williams.spring_auth_initializer.auth.entities.User;
import com.williams.spring_auth_initializer.auth.entities.util.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByRole(Role role);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}