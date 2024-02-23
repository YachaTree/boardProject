package com.Tree_dev.workout_done.user.controller;

import com.Tree_dev.workout_done.user.entity.User;
import com.Tree_dev.workout_done.user.mapper.UserMapper;
import com.Tree_dev.workout_done.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<User> users = userService.findUsers(page, size);
        List<User> content = users.getContent();

        if (content.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @GetMapping("/email-search")
    public List<User> getUserByEmailEndingWith(@RequestParam(name = "email") String email) {
        return userService.findUserByEmailEndingWith(email);
    }
}
