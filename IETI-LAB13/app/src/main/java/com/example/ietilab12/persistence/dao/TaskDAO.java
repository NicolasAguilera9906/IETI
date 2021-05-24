package com.example.ietilab12.persistence.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.ietilab12.persistence.entities.Task;

import java.util.List;

@Dao
public interface TaskDAO {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Insert
    void insertAll(List<Task> tasks);

    @Query("DELETE FROM tasks")
    void deleteAll();


    @Query("SELECT * FROM tasks")
    List<Task> getTasks();
}