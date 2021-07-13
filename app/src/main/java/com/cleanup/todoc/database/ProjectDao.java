package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;


    @Dao
    public interface  ProjectDao {

        //Insert project
        @Insert
        void insertProjects(Project... projects);

        // Get all projects
        @Query("SELECT * FROM Project")
        LiveData<List<Project>> getAllProjects();

    }


