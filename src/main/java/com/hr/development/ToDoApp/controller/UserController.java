package com.hr.development.ToDoApp.controller;

import com.hr.development.ToDoApp.entities.User;
import com.hr.development.ToDoApp.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/getSingleUser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){

        User singleUser = userService.getSingleUser(userId);
        return new ResponseEntity<>(singleUser, HttpStatus.OK);
    }

    @PostMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }
}
