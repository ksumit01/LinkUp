package com.LinkUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LinkUp.Model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {
    // Add custom query methods if needed
}

