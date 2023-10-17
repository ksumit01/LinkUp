package com.LinkUp.Model;

import com.LinkUp.Model.*;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String email;
    private String password;
    private String role;
    private String name;
    private String profilePicture;

    @OneToMany(mappedBy = "projectManager")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Project> managedProjects;

    @ManyToMany(mappedBy = "teamMembers")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Team> teams;

    @OneToMany(mappedBy = "assignedUser")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Task> assignedTasks;

    @OneToMany(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Notification> notifications;
}

































//import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//@Entity
//@Data
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String name;
//    private String email;
//    private String password;
//    private String role;
//    private String profilePic;
//
//    @OneToMany(mappedBy = "projectManager")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Project> managedProjects;
//
//    @ManyToMany
//    @JoinTable(
//        name = "team_membership",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "team_id")
//    )
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Team> teams;
//}

