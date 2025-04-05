package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.*;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;

import java.util.UUID;

@Mapper
public interface HabitRepository {
    @Select("SELECT * FROM habits WHERE habit_id = #{habitId}")
    @Results(id = "habitMapper", value = {
            @Result(property = "habitId", column = "habit_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "frequency", column = "frequency"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "appUserResponse", column = "app_user_id", one = @One(select = "org.example.pvh_group_01_spring_mini_project.repository.ProfileRepository.getHabitProfile")),
            @Result(property = "createAt", column = "created_at")
    })
    Habit getHabitById(UUID habitId);
}
