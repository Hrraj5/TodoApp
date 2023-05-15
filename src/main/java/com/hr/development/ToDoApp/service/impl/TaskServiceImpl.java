package com.hr.development.ToDoApp.service.impl;

import com.hr.development.ToDoApp.entities.Tasks;
import com.hr.development.ToDoApp.repsositories.TaskRespository;
import com.hr.development.ToDoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRespository taskRespository;
    @Override
    public Tasks saveTask(Tasks task) {
        return taskRespository.save(task);
    }
}
