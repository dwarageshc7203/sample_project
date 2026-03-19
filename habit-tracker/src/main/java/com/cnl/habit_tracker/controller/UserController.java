package com.cnl.habit_tracker.controller;

import com.cnl.habit_tracker.models.User;
import com.cnl.habit_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping()
    public User getUser(@PathVariable int userId) {
        return service.getUser(userId);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }

    @DeleteMapping()
    public void deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
    }

}
