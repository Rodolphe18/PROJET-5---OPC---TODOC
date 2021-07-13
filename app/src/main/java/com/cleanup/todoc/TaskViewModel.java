package com.cleanup.todoc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.ProjectRepository;
import com.cleanup.todoc.repository.TaskRepository;

import java.util.List;
import java.util.concurrent.Executor;


public class TaskViewModel extends ViewModel {

    //REPOSITORIES
    private final TaskRepository taskDataSource;
    private final ProjectRepository projectDataSource;
    private final Executor executor;

    //DATA
    @Nullable
    private LiveData<List<Project>> projects;

    public TaskViewModel(TaskRepository taskDataSource, ProjectRepository projectDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.projectDataSource = projectDataSource;
        this.executor = executor;
    }

    public void init() {
        if (projects == null)
            projects = projectDataSource.getAllProjects();
    }

    // -------------
    // FOR PROJECT
    // -------------
    public LiveData<List<Project>> getAllProjects(){
        return projects;
    }

    // -------------
    // FOR TASK
    // -------------

    public LiveData<List<Task>> getAllTasks() {
        return taskDataSource.getAllTasks();
    }

    public void createTask(final Task task) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                taskDataSource.createTask(task);
            }
        };
        executor.execute(runnable);
    }

    public void deleteTask(final long taskId) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                taskDataSource.deleteTask(taskId);
            }
        };
        executor.execute(runnable);
    }
}
