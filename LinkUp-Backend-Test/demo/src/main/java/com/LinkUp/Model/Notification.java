package com.LinkUp.Model;

import java.time.LocalDateTime;
import java.util.List;
import com.LinkUp.Model.Content;
import com.LinkUp.Model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @ManyToMany
    @JoinTable(
        name = "Notification_Content",
        joinColumns = @JoinColumn(name = "notification_id"),
        inverseJoinColumns = @JoinColumn(name = "content_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Content> contents;

    private LocalDateTime createdAt;
}
