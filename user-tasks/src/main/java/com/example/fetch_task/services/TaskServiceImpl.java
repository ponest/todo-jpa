package com.example.fetch_task.services;

import com.example.fetch_task.TaskService;
import com.example.fetch_task.entities.Task;
import com.example.fetch_task.enums.TaskStatus;
import com.example.fetch_task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // 1. Get all tasks by status
    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {

        return taskRepository.findByTaskStatus(status);
    }

    // 2. Get user tasks by status
    @Override
    public List<Task> getUserTasksByStatus(Long userId, TaskStatus status) {

        return taskRepository.findByUserIdAndTaskStatus(userId, status);
    }

    // 3. Get all user tasks
    @Override
    public List<Task> getAllUserTasks(Long userId) {

        return taskRepository.findByUserId(userId);
    }
}