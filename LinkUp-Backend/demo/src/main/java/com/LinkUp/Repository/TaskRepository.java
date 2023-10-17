package com.LinkUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LinkUp.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Define custom query methods if needed
}

