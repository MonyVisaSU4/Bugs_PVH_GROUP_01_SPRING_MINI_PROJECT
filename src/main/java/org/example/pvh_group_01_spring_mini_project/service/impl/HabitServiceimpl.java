package org.example.pvh_group_01_spring_mini_project.service.impl;

import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;
import org.example.pvh_group_01_spring_mini_project.repository.HabitRepository;
import org.example.pvh_group_01_spring_mini_project.service.HabitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceimpl implements HabitService {
    private final HabitRepository habitRepository;
    public HabitServiceimpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public List<Habit> getAllHabits(Integer page, Integer size) {
        return habitRepository.getAllHabits(page, size);
    }

    @Override
    public Habit getHabitById(int id) {
        return null;
    }

    @Override
    public Habit createHabit(HabitRequest habitRequest) {
        return null;
    }
}
