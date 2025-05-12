package com.williams.spring_auth_initializer.auth.controller;

import com.williams.spring_auth_initializer.auth.entities.User;
import com.williams.spring_auth_initializer.auth.entities.util.Role;
import com.williams.spring_auth_initializer.auth.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        log.info("REST request to find one user");
        Optional<User> userOpt = this.userService.findById(id);

        return userOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<User> findAll() {
        log.info("REST request to find all user");
        return userService.findAll();
    }

    @PutMapping("/permission/{id}")
    public ResponseEntity<User> updateRole(@PathVariable Long id) {
        if (this.userService.findById(id).isPresent()) {
            User user = this.userService.findById(id).get();

            if (user.getRole().equals(Role.CUSTOMER)) {
                user.setRole(Role.ADMINISTRATOR);
                log.info("REST request to update Role ADMINISTRATOR a user with id: " + user.getId());

                return ResponseEntity.ok(this.userService.save(user));
            }
        }
        log.warn("Update Role failed");
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/permission/revoque/{id}")
    public ResponseEntity<User> revoqueRole(@PathVariable Long id) {
        if (this.userService.findById(id).isPresent()) {
            User user = this.userService.findById(id).get();

            if (!user.getRole().equals(Role.CUSTOMER)) {
                user.setRole(Role.CUSTOMER);
                log.info("REST request to revoque Role ADMINISTRATOR a user with id: " + user.getId());

                return ResponseEntity.ok(this.userService.save(user));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        log.info("REST request to delete an user by id");

        this.userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        log.info("REST request to count all users");
        Long count = this.userService.count();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{role}")
    public List<User> findByRole(@PathVariable Role role) {
        log.info("REST request to find user by Role: " + role.name());
        return this.userService.findByRole(role);
    }
}
