package com.cnl.habit_tracker.model.dto;

public record HabitResponse(

        int habitId,
        String habitName,
        String description,
        Boolean isActive

) {
}
