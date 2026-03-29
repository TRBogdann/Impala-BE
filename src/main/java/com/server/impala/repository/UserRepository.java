package com.server.impala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.server.impala.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}