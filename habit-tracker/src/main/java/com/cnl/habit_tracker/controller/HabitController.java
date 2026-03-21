package com.cnl.habit_tracker.controller;

import com.cnl.habit_tracker.model.Habit;
import com.cnl.habit_tracker.model.dto.HabitRequest;
import com.cnl.habit_tracker.model.dto.HabitResponse;
import com.cnl.habit_tracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class HabitController {

    @Autowired
    private HabitService service;

    //create habit
    @PostMapping("/create")
    public ResponseEntity<Void> createHabit(@RequestBody HabitRequest habitRequest) {
        service.createHabit(habitRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //get habits
    @GetMapping("/habit/{habitId}")
    public ResponseEntity<HabitResponse> getHabit(@PathVariable int habitId) {
        HabitResponse habitResponse = service.getHabit(habitId);
        if(habitResponse.habitId() > 0) {
            return new ResponseEntity<>(habitResponse, HttpStatus.OK );
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/habits")
    public ResponseEntity<List<HabitResponse>> getAllHabits() {
        return new ResponseEntity<>(service.getAllHabits(), HttpStatus.OK);
    }

    //update habit
    @PutMapping("/update/{habitId}")
    public ResponseEntity<Void> updateHabit(@PathVariable int habitId, @RequestBody HabitRequest habitRequest) {
        service.updateHabit(habitId, habitRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete habit
    @DeleteMapping("/delete/{habitId}")
    public ResponseEntity<Void> deleteHabit(@PathVariable int habitId) {
        service.deleteHabit(habitId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //search habit
    @GetMapping("/search")
    public ResponseEntity<List<HabitResponse>> searchBy(@RequestParam String keyword) {
        List<HabitResponse> list = service.searchByKeyword(keyword);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

}
