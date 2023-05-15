package com.hr.development.ToDoApp.service;

import com.hr.development.ToDoApp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User getSingleUser(String userId);
    List<User> getAllUsers();
    User saveUser(User user);
}
