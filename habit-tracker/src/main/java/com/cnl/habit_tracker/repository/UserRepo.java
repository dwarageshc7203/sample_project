package com.cnl.habit_tracker.repository;

import com.cnl.habit_tracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
