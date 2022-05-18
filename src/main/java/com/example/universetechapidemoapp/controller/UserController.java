package com.example.universetechapidemoapp.controller;

import com.example.universetechapidemoapp.model.User;
import com.example.universetechapidemoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAll() {
        var users = userRepository.findAll();
        log.info("{} - User controller triggered", LocalTime.now());
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        log.info("{} - Getting User: {}", LocalTime.now(), id);
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("{} - Saving User: {}", LocalTime.now(), user);
        return userRepository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        var userToUpdate = userRepository.findById(user.getId()).get();
        BeanUtils.copyProperties(user, userToUpdate);
        log.info("{} - Updating User: {}", LocalTime.now(), userToUpdate);
        return userRepository.save(userToUpdate);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        log.info("{} - Deleting User: {}", LocalTime.now(), id);
    }

    @PostConstruct
    public void postConstruct() {
        var users = List.of(
                new User(1L, "Alex", "123-"),
                new User(2L, "Ivan", "321-")
        );
        userRepository.saveAll(users);
        log.info("{} - Post Construct Saving Users : {}", LocalTime.now(), users);
    }
}
