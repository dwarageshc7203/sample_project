package com.cnl.habit_tracker.controller;

import com.cnl.habit_tracker.models.Habit;
import com.cnl.habit_tracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HabitController {

    @Autowired
    private HabitService service;

    @PostMapping()
    public void createHabit(@RequestBody Habit habit) {
        service.createHabit(habit);
    }

    @GetMapping()
    public Habit getHabit(@PathVariable int habitId) {
        return service.getHabit(habitId);
    }

    @GetMapping()
    public List<Habit> getAllHabits() {
        return service.getAllHabits();
    }

    @PutMapping()
    public void updateHabit(@RequestBody Habit habit) {
        service.updateHabit(habit);
    }

    @DeleteMapping()
    public void deleteHabit(@PathVariable int habitId) {
        service.deleteHabit(habitId);
    }

}
