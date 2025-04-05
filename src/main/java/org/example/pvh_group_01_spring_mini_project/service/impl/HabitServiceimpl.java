package org.example.pvh_group_01_spring_mini_project.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;
import org.example.pvh_group_01_spring_mini_project.repository.HabitRepository;
import org.example.pvh_group_01_spring_mini_project.service.HabitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceimpl implements HabitService {
    private final HabitRepository habitRepository;
    @Override
    public List<Habit> getAllHabits() {
        return habitRepository.getAllHabits();
    }

    @Override
    public Habit addHabit(HabitRequest habitRequest) {
        return habitRepository.addHabit(habitRequest);
    }
}
