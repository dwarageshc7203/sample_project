package com.cnl.habit_tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
public class User {

    @Id
    private int userId;
    private String userName;
    private int progress;

}
