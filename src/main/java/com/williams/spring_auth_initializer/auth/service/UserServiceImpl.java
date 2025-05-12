package com.williams.spring_auth_initializer.auth.service;

import com.williams.spring_auth_initializer.auth.entities.User;
import com.williams.spring_auth_initializer.auth.entities.util.Role;
import com.williams.spring_auth_initializer.auth.repository.UserRepository;
import com.williams.spring_auth_initializer.auth.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        log.info("Executing findAll Users");
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        log.info("Executing findById");
        return this.userRepository.findById(id);
    }

    @Override
    public Long count() {
        log.info("Get total number of users");
        return this.userRepository.count();
    }

    @Override
    public User save(User user) {
        log.info(user.getId() == null ? "Creating User" : "Updating User");
        try {
            User userSave = this.userRepository.save(user);
            log.info("User save correct");
            return userSave;
        } catch (Exception e) {
            log.error("Error trying to create user",e);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting user by id: " + id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error trying to delete user by id {}", id, e);
        }
    }

    @Override
    public List<User> findByRole(Role role) {
        log.info("Executing findByRole");
        return this.userRepository.findByRole(role);
    }
}
