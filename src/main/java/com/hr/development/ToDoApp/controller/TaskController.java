package com.hr.development.ToDoApp.controller;

import com.hr.development.ToDoApp.entities.Tasks;
import com.hr.development.ToDoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @PostMapping("/saveTasks")
    public ResponseEntity<Tasks> saveTask(@RequestBody Tasks task){
        Tasks savedTask  = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }
}
