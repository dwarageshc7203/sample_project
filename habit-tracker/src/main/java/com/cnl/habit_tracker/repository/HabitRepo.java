package com.cnl.habit_tracker.repository;

import com.cnl.habit_tracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepo extends JpaRepository<Habit, Integer> {
}
