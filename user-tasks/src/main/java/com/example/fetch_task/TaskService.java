package com.example.fetch_task;

import com.example.fetch_task.entities.Task;
import com.example.fetch_task.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    List<Task> getTasksByStatus(TaskStatus status);

    List<Task> getUserTasksByStatus(Long userId, TaskStatus status);

    List<Task> getAllUserTasks(Long userId);
}
