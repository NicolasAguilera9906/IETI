package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "tasks" )
public class TaskController
{

    @Autowired
    private TaskService taskService;

    @CrossOrigin(origins = "*")
    @RequestMapping( value = "", method = RequestMethod.POST )
    public Task addTask(@RequestBody Task task ) throws Exception {
        taskService.createTask(task);
        return task;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping( value = "", method = RequestMethod.GET )
    public List<Task> getTasks() throws Exception {
        List<Task> tasks = taskService.getTasks();
        return tasks;
    }

}
