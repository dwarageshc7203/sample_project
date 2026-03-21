package com.cnl.habit_tracker.repository;

import com.cnl.habit_tracker.model.Habit;
import com.cnl.habit_tracker.model.dto.HabitResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitRepo extends JpaRepository<Habit, Integer> {

    @Query(
            "SELECT h from Habit h WHERE " +
                    "LOWER(h.habitName) LIKE LOWER(CONCAT('%', :keyword, '%'))"
    )
    List<HabitResponse> searchByKeyword(String keyword);
}
