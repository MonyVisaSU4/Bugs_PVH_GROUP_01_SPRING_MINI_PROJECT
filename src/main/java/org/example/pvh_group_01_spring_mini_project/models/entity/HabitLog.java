package org.example.pvh_group_01_spring_mini_project.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitLog {
    private UUID habitLogId;
    private LocalDate logDate;
    private Status status;
    private Integer xpEarned;
    private Habit habit; //Changed from HabitId to Habit
//    private UUID habitId; // Changed from Integer to UUID
    private LocalDateTime createdAt;

    public enum Status{
        COMPLETED,
        MISSED
    }
}