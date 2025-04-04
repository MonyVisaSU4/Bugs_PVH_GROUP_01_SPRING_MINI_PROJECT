package org.example.pvh_group_01_spring_mini_project.controllers;

import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitController {
    public Habit deleteHabit(HabitRequest habitRequest) {
        return null;
    }
}
