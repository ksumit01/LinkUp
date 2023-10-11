package com.LinkUp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Model.Content;
import com.LinkUp.Model.Notification;
import com.LinkUp.Model.User;
import com.LinkUp.Repository.NotificationRepository;
import com.LinkUp.Repository.UserRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Notification createNotification(User user, List<Content> contents) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setContents(contents);
        notification.setCreatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    
    @Override
    public List<Notification> getUserNotifications(Long userId) {
        // Check if the user exists
        User user = userRepository.findById(userId).orElse(null);
        
        if (user == null) {
            // Handle the case where the user doesn't exist, e.g., throw an exception or return an error response
            // You can also add custom exception handling here
            throw new NotFoundException("User not found.");
        }

        // Retrieve notifications for the user by user ID
        List<Notification> userNotifications = notificationRepository.findByUserId(userId);

        // You can add additional logic here if needed, such as marking notifications as read

        return userNotifications;
    }



    // Implement other methods as needed
}

