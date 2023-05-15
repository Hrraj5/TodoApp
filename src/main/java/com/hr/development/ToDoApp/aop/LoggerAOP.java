package com.hr.development.ToDoApp.aop;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAOP {
    private Logger looger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(public * com.hr.development.ToDoApp.controller.TaskController.saveTask())")
    public void printLogsBeforeSavingtheEntity(){
        looger.debug("Saving the Entity");
    }
}
