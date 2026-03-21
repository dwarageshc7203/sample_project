package com.cnl.habit_tracker.model.dto;

public record HabitRequest(

        String habitName,
        String description,
        Boolean isActive

) {
}
