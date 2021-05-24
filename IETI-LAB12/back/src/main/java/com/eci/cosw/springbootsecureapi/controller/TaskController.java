package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/" )
public class TaskController
{

    @Autowired
    private TaskService taskService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/tasks", method = RequestMethod.POST )
    public Task addTask(@RequestBody Task task ) throws Exception {
        taskService.createTask(task);
        return task;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/tasks", method = RequestMethod.GET )
    public List<Task> getTaskS() throws Exception {
        List<Task> tasks = taskService.getTasks();
        return tasks;
    }

}
