package com.LinkUp.Model;

import  com.LinkUp.Model.User;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    private String teamName;

    @ManyToMany
    @JoinTable(
        name = "Team_Member",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<User> teamMembers;
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
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//import com.LinkUp.Model.Task;
//
//@Entity
//@Data
//public class Team {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String teamName;
//
//    @ManyToMany
//    @JoinTable(
//        name = "team_membership",
//        joinColumns = @JoinColumn(name = "team_id"),
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<User> teamMembers;
//
//    @ManyToMany
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Task> tasks;
//}

