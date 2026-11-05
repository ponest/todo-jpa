package com.example.fetch_task.dto;

import com.example.fetch_task.enums.NotificationStatus;

import java.time.Instant;

public class NotificationResponse {

    private Long id;
    private String clientId;
    private String title;
    private String message;
    private Instant scheduledAt;
    private Instant createdAt;
    private Instant sentAt;
    private String status;
    private boolean isRead;

    public NotificationResponse() {
    }

    public NotificationResponse(Long id, String clientId, String title, String message,
                                Instant scheduledAt, Instant createdAt, Instant sentAt,
                                String status, boolean isRead) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.message = message;
        this.scheduledAt = scheduledAt;
        this.createdAt = createdAt;
        this.sentAt = sentAt;
        this.status = status;
        this.isRead = isRead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Instant scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getSentAt() {
        return sentAt;
    }

    public void setSentAt(Instant sentAt) {
        this.sentAt = sentAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}