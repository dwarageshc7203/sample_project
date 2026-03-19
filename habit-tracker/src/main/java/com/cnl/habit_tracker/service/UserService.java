package com.cnl.habit_tracker.service;

import com.cnl.habit_tracker.models.User;
import com.cnl.habit_tracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public void createUser(User user) {
        repo.save(user);
    }

    public User getUser(int userId) {
        return repo.findById(userId).orElse(new User());
    }

    public void updateUser(User user) {
        repo.save(user);
    }

    public void deleteUser(int userId) {
        repo.deleteById(userId);
    }

}
