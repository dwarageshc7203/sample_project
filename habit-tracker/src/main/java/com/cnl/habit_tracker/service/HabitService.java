package com.cnl.habit_tracker.service;

import com.cnl.habit_tracker.model.Habit;
import com.cnl.habit_tracker.model.dto.HabitRequest;
import com.cnl.habit_tracker.model.dto.HabitResponse;
import com.cnl.habit_tracker.repository.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepo repo;

    private HabitResponse toResponse(Habit habit) {
        HabitResponse habitResponse = new HabitResponse(
                habit.getHabitId(),
                habit.getHabitName(),
                habit.getDescription(),
                habit.getIsActive()
        );
        return habitResponse;
    }

    public void createHabit(HabitRequest habitRequest) {
        Habit habit = new Habit();

        habit.setHabitName(habitRequest.habitName());
        habit.setDescription(habitRequest.description());
        habit.setIsActive(habitRequest.isActive());

        repo.save(habit);

    }

    public HabitResponse getHabit(int habitId) {
        Habit habit = repo.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not Fouund"));
        return toResponse(habit);
    }

    public List<HabitResponse> getAllHabits() {
        List<HabitResponse> responses = repo.findAll().stream().map(this::toResponse).toList();
        return responses;
    }

    public void updateHabit(int habitId, HabitRequest habitRequest) {
        Habit habit = repo.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        habit.setHabitName(habitRequest.habitName());
        habit.setDescription(habitRequest.description());
        habit.setIsActive(habitRequest.isActive());

        repo.save(habit);

    }

    public void deleteHabit(int habitId) {
        repo.deleteById(habitId);
    }

    public List<HabitResponse> searchByKeyword(String keyword) {
        System.out.println("Searching by '" + keyword + "'" );
        return repo.searchByKeyword(keyword);
    }
}
