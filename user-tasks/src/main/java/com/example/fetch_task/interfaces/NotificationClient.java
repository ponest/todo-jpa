package com.example.fetch_task.interfaces;

import com.example.fetch_task.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notification-service")
public interface NotificationClient {

        @GetMapping("/api/notifications/client/{clientId}")
        List<NotificationResponse> findAllNotificationByClientId(@PathVariable("clientId") Long clientId);

        @GetMapping("/api/notifications/{id}")
        NotificationResponse findByNotificationId(@PathVariable("id") Long id);

        @PatchMapping("/api/notifications/{id}/read")
        public NotificationResponse markAsRead(@PathVariable("id")Long id);

}
