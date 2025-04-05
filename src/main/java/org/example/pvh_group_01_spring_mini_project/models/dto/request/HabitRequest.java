package org.example.pvh_group_01_spring_mini_project.models.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitRequest {
    @NotBlank(message = "Title Should not be Blank!!!")
    private String title;
    @Size(min = 2, max = 200, message = "Sorry, Your description is too long!!!")
    private String description;
    @NotBlank(message = "Frequency Should not be Blank!!!")
    private String frequency;
}