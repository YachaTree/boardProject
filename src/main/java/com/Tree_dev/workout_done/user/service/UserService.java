package com.Tree_dev.workout_done.user.service;

import com.Tree_dev.workout_done.user.entity.User;
import com.Tree_dev.workout_done.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page- 1, size, Sort.by("userId").ascending()));
    }

    public List<User> getContent() {
        return userRepository.findAll();
    }

    public List<User> findUserByEmailEndingWith(String email) {
        return userRepository.findByEmailEndingWith(email);
    }

}
