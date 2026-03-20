package com.cnl.habit_tracker.controller;

import com.cnl.habit_tracker.model.Habit;
import com.cnl.habit_tracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HabitController {

    @Autowired
    private HabitService service;

    @PostMapping("/create")
    public ResponseEntity<Void> createHabit(@RequestBody Habit habit) {
        service.createHabit(habit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("habit/{habitId}")
    public ResponseEntity<Habit> getHabit(@PathVariable int habitId) {
        return new ResponseEntity<>(service.getHabit(habitId),HttpStatus.OK );
    }

    @GetMapping("habits")
    public ResponseEntity<List<Habit>> getAllHabits() {
        return new ResponseEntity<>(service.getAllHabits(), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateHabit(@RequestBody Habit habit) {
        service.updateHabit(habit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{habitId}")
    public ResponseEntity<Void> deleteHabit(@PathVariable int habitId) {
        service.deleteHabit(habitId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}
