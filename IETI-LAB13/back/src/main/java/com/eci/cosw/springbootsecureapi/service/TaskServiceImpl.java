package com.eci.cosw.springbootsecureapi.service;


import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    private List<Task> tasks = new ArrayList<>();

    @PostConstruct
    private void populateSampleData() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        User user = new User( "test@mail.com", "password", "Andres", "Perez" );
        tasks.add( new Task(  tasks.size(),"New task", dateObject, user , "done" ) );
        tasks.add( new Task(  tasks.size(),"Do the homework", dateObject, user , "not over" ) );

    }

    @Autowired
    public TaskServiceImpl() { }

    @Override
    public Task createTask(Task task) {
        task.setId(tasks.size());
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }
}
