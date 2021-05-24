package com.example.ietilab12.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ietilab12.persistence.entities.Task;
import com.example.ietilab12.persistence.repository.TaskRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TasksViewModel extends AndroidViewModel {

    private MutableLiveData<List<Task>> taskList;
    private TaskRepository taskRepository;
    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public TasksViewModel(Application application) {
        super(application);
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public LiveData<List<Task>> getTaskList() {
        if (taskList == null) {
            taskList = new MutableLiveData<>();
            loadTasks();
        }
        return taskList;
    }

    private void loadTasks() {
        executorService.execute(() -> taskList.postValue(taskRepository.getTasks()));
    }


}


