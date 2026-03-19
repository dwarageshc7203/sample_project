package com.cnl.habit_tracker.service;

import com.cnl.habit_tracker.models.Habit;
import com.cnl.habit_tracker.repository.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepo repo;

    public void createHabit(Habit habit) {
        repo.save(habit);
    }

    public Habit getHabit(int habitId) {
        return repo.findById(habitId).orElse(new Habit());
    }

    public List<Habit> getAllHabits() {
        return repo.findAll();
    }

    public void updateHabit(Habit habit) {
        repo.save(habit);
    }

    public void deleteHabit(int habitId) {
        repo.deleteById(habitId);
    }
}
