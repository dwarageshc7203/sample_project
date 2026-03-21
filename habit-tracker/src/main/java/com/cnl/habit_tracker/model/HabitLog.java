package com.cnl.habit_tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;
    private LocalDate date;
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habits;

}
