package com.example.subscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.subscriptionservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
