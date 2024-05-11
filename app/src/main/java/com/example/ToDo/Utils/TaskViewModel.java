package com.example.ToDo.Utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.ToDo.Model.Task;
import com.example.ToDo.Utils.TaskRepository;
import java.util.List;

public class TaskViewModel extends ViewModel {
    private TaskRepository taskRepository;
    private LiveData<List<Task>> allTasks;

    // Zero-argument constructor
    public TaskViewModel() {
        // Initialize taskRepository and allTasks to default values, if necessary
    }

    public TaskViewModel(TaskRepository taskRepository) {
        if (taskRepository == null) {
            throw new IllegalArgumentException("TaskRepository cannot be null");
        }
        this.taskRepository = taskRepository;
        allTasks = taskRepository.getAllTasksLiveData();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insertTask(Task task) {
        if (taskRepository != null) {
            taskRepository.insertTask(task);
        }
    }

    public void updateTask(Task task) {
        if (taskRepository != null) {
            taskRepository.updateTask(task);
        }
    }

    public void deleteTask(Task task) {
        if (taskRepository != null) {
            taskRepository.deleteTask(task);
        }
    }

    public void init(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        allTasks = taskRepository.getAllTasksLiveData();
    }
}
