package com.hr.development.ToDoApp.service;

import com.hr.development.ToDoApp.entities.Tasks;
import org.springframework.stereotype.Service;

@Service
public interface TaskService{
    Tasks saveTask(Tasks task);
}
