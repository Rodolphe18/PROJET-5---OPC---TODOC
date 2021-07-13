package com.cleanup.todoc.repository;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskRepository {

    private final TaskDao taskDao;

    public TaskRepository(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    //CREATE
    public void createTask(Task task){
        taskDao.insertTask(task);
    }

    //DELETE
    public void deleteTask(long id){
        taskDao.deleteTask(id);
    }

    //GET ALL TASKS
    public LiveData<List<Task>> getAllTasks(){
        return taskDao.getAllTasks();
    }
}
