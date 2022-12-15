package com.example.review.service;


import com.example.review.model.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    List<User> getAllUsers();

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
