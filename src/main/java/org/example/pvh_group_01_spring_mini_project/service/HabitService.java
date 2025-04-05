package org.example.pvh_group_01_spring_mini_project.service;

import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;

import java.util.List;

public interface HabitService {
    List<Habit> getAllHabits(Integer page, Integer size);
    Habit getHabitById(int id);
    Habit createHabit(HabitRequest habitRequest);
}
