package com.example.fetch_task.controller;

import com.example.fetch_task.TaskService;
import com.example.fetch_task.dto.NotificationResponse;
import com.example.fetch_task.entities.Task;
import com.example.fetch_task.enums.TaskStatus;
import com.example.fetch_task.interfaces.NotificationClient;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fetch-task")

public class TaskController {

    private final TaskService taskService;
    private final NotificationClient notificationClient;

    public TaskController(TaskService taskService,
                          NotificationClient notificationClient){
        this.taskService =taskService;
        this.notificationClient = notificationClient;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {

        return ResponseEntity.ok(
                taskService.getTasksByStatus(status)
        );
    }

    @RateLimiter(name = "taskServiceRateLimiter", fallbackMethod = "taskRateLimiter")
    @GetMapping("/user/{userId}/status/{status}")
    public ResponseEntity<List<Task>> getUserTasksByStatus(
            @PathVariable Long userId,
            @PathVariable TaskStatus status) {

        return ResponseEntity.ok(taskService.getUserTasksByStatus(userId, status)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getAllUserTasks(
            @PathVariable Long userId) {

        return ResponseEntity.ok(taskService.getAllUserTasks(userId)
        );
    }


    public ResponseEntity<String> taskRateLimiter(RequestNotPermitted exception) {
        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS) // HTTP 429
                .header("Retry-After", "10")
                .body("Too Many Requests! The rate limit has been exceeded. Please try again later.");
    }

    @GetMapping("/notifications-feign/{id}")
    public ResponseEntity<List<NotificationResponse>> getOrganizationInformation(@PathVariable("id") Long id) {

        List notifications = notificationClient.findAllNotificationByClientId(id);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(notifications, HttpStatus.OK);

    }


}