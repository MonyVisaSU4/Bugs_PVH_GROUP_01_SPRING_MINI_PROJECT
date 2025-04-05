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
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiRespones<Habit>> deleteHabit(@PathVariable UUID id) {
        habitService.deleteHabit(id);
        ApiRespones<Habit> response = ApiRespones.<Habit>builder()
                .success(true)
                .message("Habit successfully Deleted")
                .status(HttpStatus.OK)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiRespones<Habit>> updateHabit(@PathVariable UUID id, @RequestBody HabitRequest habitRequest) {
        ApiRespones<Habit> response = ApiRespones.<Habit>builder()
                .success(true)
                .message("Habit successfully Updated")
                .status(HttpStatus.OK)
                .payload(habitService.updateHabit(id, habitRequest))
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
