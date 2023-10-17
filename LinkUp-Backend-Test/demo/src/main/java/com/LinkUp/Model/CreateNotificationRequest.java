package com.LinkUp.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateNotificationRequest {
    private Long userId;
    private List<Long> contentIds;

    // Getters and setters
}

