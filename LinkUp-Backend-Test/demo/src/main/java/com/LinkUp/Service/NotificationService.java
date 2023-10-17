package com.LinkUp.Service;

import java.util.List;

import com.LinkUp.Model.Content;
import com.LinkUp.Model.Notification;
import com.LinkUp.Model.User;

public interface NotificationService {
    Notification createNotification(User user, List<Content> contents);
    List<Notification> getUserNotifications(Long userId);
    // Add more methods as needed
}

