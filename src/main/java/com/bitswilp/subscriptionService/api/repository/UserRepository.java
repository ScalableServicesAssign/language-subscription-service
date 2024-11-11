package com.bitswilp.subscriptionService.api.repository;

import com.bitswilp.subscriptionService.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by username or email (assuming `username` is a unique field)
    User findByEmail(String email);
}
