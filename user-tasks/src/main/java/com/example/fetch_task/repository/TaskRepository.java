package com.example.fetch_task.repository;

import com.example.fetch_task.entities.Task;
import com.example.fetch_task.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // 1. Get all tasks by status
    List<Task> findByTaskStatus(TaskStatus status);

    // 2. Get user tasks by status
    List<Task> findByUserIdAndTaskStatus(Long userId, TaskStatus status);

    // 3. Get all tasks belonging to a user
    List<Task> findByUserId(Long userId);
}