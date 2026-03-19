package com.cnl.habit_tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
public class Habit {

    @Id
    private int habitId;
    private String habitName;
    private String type;

}
