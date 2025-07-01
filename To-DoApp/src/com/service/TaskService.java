package com.service;


import com.dto.TaskDTO;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<TaskDTO> tasks = new ArrayList<>();

    public void addTask(TaskDTO task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public List<TaskDTO> getAllTasks() {
        return tasks;
    }
}

