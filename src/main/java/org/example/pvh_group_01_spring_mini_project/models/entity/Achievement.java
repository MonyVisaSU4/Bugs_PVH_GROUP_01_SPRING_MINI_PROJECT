package org.example.pvh_group_01_spring_mini_project.models.entity;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Achievement {
    private UUID achievementId;
    private String title;
    private String description;
    private String badge;
    private Integer xpRequired;
}
