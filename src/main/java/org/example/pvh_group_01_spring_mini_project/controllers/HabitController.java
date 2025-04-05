package org.example.pvh_group_01_spring_mini_project.controllers;

import lombok.RequiredArgsConstructor;
import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitRequest;
import org.example.pvh_group_01_spring_mini_project.models.dto.response.ApiRespones;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;
import org.example.pvh_group_01_spring_mini_project.service.HabitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;
    @GetMapping
    public ResponseEntity<ApiRespones<List<Habit>>> getAllHabits() {
        ApiRespones<List<Habit>> respones = ApiRespones.<List<Habit>>builder()
                .success(true)
                .message("Get All Habits Successfully")
                .status(HttpStatus.OK)
                .payload(habitService.getAllHabits())
                .timestamps(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(respones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiRespones<Habit>> addHabit(@RequestBody HabitRequest habitRequest) {
        ApiRespones<Habit> respones = ApiRespones.<Habit>builder()
                .success(true)
                .message("Added Habit Successfully")
                .status(HttpStatus.OK)
                .payload(habitService.addHabit(habitRequest))
                .timestamps(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(respones, HttpStatus.OK);
    }


}

