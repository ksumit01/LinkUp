package com.LinkUp.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    private String taskTitle;
    private String description;
    private Date dueDate;
    private String priority;
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_project_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Project assignedProject;

    @ManyToOne
    @JoinColumn(name = "assigned_team_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Team assignedTeam;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User assignedUser;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Task parentTask;
}

















//import java.util.Date;
//import java.util.List;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//import com.LinkUp.Model.Team;
//
//@Entity
//@Data
//public class Task {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String title;
//    private String description;
//    private Date dueDate;
//    private String priority;
//    private String status;
//
//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project;
//
//    @ManyToMany(mappedBy = "tasks")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Team> teams;
//}
