package com.LinkUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LinkUp.Model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Define custom query methods if needed
}
