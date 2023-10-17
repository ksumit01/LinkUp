package com.LinkUp.model;

import java.sql.Date;

import com.LinkUp.enums.Priority;
import com.LinkUp.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Status status;

    
    @ManyToOne
    private Project project;
    

    @ManyToOne
    private Users assigned;

    
}
