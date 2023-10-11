package com.LinkUp.Model;

import com.LinkUp.Model.User;
import com.LinkUp.Model.Task;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Setter
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "project_manager_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User projectManager;

    @OneToMany(mappedBy = "assignedProject")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Task> tasks;

    @ManyToOne // Many projects can be associated with one team
    @JoinColumn(name = "team_id") // The foreign key column in the Project table
    private Team assignedTeam; // The team associated with the project

}















//import java.util.Date;
//import java.util.List;
//import com.LinkUp.Model.Task; // Import the correct Task class
//
//
////import org.springframework.scheduling.config.Task;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//@Entity
//@Data
//public class Project {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String name;
//    private String description;
//    private Date startDate;
//    private Date endDate;
//
//    @ManyToOne
//    @JoinColumn(name = "project_manager_id")
//    private User projectManager;
//
//    @OneToMany(mappedBy = "project")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Task> tasks;
//}
