package org.example.pvh_group_01_spring_mini_project.controllers;

import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitLogRequest;

import org.example.pvh_group_01_spring_mini_project.models.dto.response.ApiResponse;
import org.example.pvh_group_01_spring_mini_project.models.entity.HabitLog;
import org.example.pvh_group_01_spring_mini_project.service.HabitLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/habit-logs")
public class HabitLogController {
    private final HabitLogService habitLogService;


    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;

    }

    @PostMapping
    public ResponseEntity<ApiResponse<HabitLog>> addAttendee( @RequestBody HabitLogRequest habitLogRequest ) {
        HabitLog addHabitLog = habitLogService.addHabitLog(habitLogRequest);
        ApiResponse<HabitLog> response = ApiResponse.<HabitLog>builder()
                .message("Habit Log added successfully")
                .status(HttpStatus.CREATED)
                .payload(addHabitLog)
                .success(true)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<HabitLog>>> getAllHabitLogs( ) {
        List<HabitLog> getHabitLog = habitLogService.getAllHabitLog();
        ApiResponse<List<HabitLog>> response = ApiResponse.<List<HabitLog>>builder()
                .message("Habit Log get all successfully")
                .status(HttpStatus.CREATED)
                .payload(getHabitLog)
                .success(true)
                .timestamps(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
