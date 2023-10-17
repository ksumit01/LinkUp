//package com.LinkUp.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//
//@Entity
//@Data
//public class TeamMembership {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @ManyToOne
//    @JoinColumn(name = "user_id") // Change to user_id to match the User entity's ID field
//    private User user;
//    
//    @ManyToOne
//    @JoinColumn(name = "team_id") // Change to team_id to match the Team entity's ID field
//    private Team team;
//}
//
//
