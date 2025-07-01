package com.controller;

import com.dto.TaskDTO;
import com.service.TaskService;
import java.util.List;

public class TaskController {
    private TaskService service = new TaskService();

    public void addTask(String taskText) {
        TaskDTO task = new TaskDTO(taskText);
        service.addTask(task);
    }

    public void deleteTask(int index) {
        service.deleteTask(index);
    }

    public List<TaskDTO> getTasks() {
        return service.getAllTasks();
    }
}
