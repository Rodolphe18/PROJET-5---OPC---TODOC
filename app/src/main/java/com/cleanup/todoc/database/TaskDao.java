package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    // Create a new task
    @Insert
    long insertTask(Task task);

    // Delete a task
    @Query("DELETE FROM Task WHERE id = :id")
    int deleteTask(long id);

    //Get a task
    @Query("SELECT * FROM Task WHERE id = :id")
    LiveData<Task> getTask(long id);

    // Get all tasks
    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAllTasks();

}
