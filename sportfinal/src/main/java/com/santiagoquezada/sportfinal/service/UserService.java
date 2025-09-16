package com.santiagoquezada.sportfinal.service;

import com.santiagoquezada.sportfinal.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    String updateUser(Integer id, User user);
    String deleteUser(Integer id);
}
