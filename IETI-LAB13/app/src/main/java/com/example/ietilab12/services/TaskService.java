package com.example.ietilab12.services;


import com.example.ietilab12.persistence.entities.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService {

    @GET("tasks")
    Call<List<Task>> getTasks();
}
