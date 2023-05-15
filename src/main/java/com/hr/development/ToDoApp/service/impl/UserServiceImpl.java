package com.hr.development.ToDoApp.service.impl;

import com.hr.development.ToDoApp.entities.Tasks;
import com.hr.development.ToDoApp.entities.User;
import com.hr.development.ToDoApp.repsositories.TaskRespository;
import com.hr.development.ToDoApp.repsositories.UserRepository;
import com.hr.development.ToDoApp.service.TaskService;
import com.hr.development.ToDoApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRespository taskRespository;

    @Override
    public User getSingleUser(String userId) {
        Optional<User> singleUser = userRepository.findById(Integer.parseInt(userId));
        User user= null;
        if(singleUser.isPresent()){
            user = singleUser.get();
            user.setTasksList(taskRespository.findByUserId(userId));
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        Thread t = new Thread (() ->{
            System.out.print("Hello");
        });
        t.start();
        List<User> finalUser = userList.stream().map(user -> {
            user.setTasksList(taskRespository.findByUserId(user.getId().toString()));
            return user;
        }).collect(Collectors.toList());

        return finalUser;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        List<Tasks> tasksList = savedUser.getTasksList();
        Tasks tasks = new Tasks();
        List<Tasks> finalTasks =tasksList.stream().map((t)-> {
            tasks.setTaskName(t.getTaskName());
            tasks.setTaskDescription(t.getTaskDescription());
            tasks.setUser(savedUser);
            taskRespository.save(tasks);
            return tasks;
        }).collect(Collectors.toList());
        return savedUser;
    }
}
