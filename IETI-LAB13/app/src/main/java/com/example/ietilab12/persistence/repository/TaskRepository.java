package com.example.ietilab12.persistence.repository;

import android.content.Context;

import com.example.ietilab12.network.RetrofitNetwork;
import com.example.ietilab12.persistence.AppDatabase;
import com.example.ietilab12.persistence.dao.TaskDAO;
import com.example.ietilab12.persistence.entities.Task;
import com.example.ietilab12.services.TaskService;

import java.util.List;


public class TaskRepository {

    private final TaskDAO taskDao;
    private final TaskService taskService;

    public TaskRepository(String token, Context context) {
        taskDao = AppDatabase.getDatabase(context).taskDAO();
        taskService = new RetrofitNetwork(token).getTaskService();
    }



    public List<Task> getTasks() {
        try {
            List<Task> tasks = taskService.getTasks().execute().body();
            if (tasks != null) {
                taskDao.deleteAll();
                taskDao.insertAll(tasks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskDao.getTasks();
    }

    public void insertAll(List<Task> tasks) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.insertAll(tasks);
        });
    }
}