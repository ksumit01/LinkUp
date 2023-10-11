package com.LinkUp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LinkUp.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define custom query methods if needed
	List<User> findByEmail(String email);
}
