package com.LinkUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LinkUp.Model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Define custom query methods if needed
}

