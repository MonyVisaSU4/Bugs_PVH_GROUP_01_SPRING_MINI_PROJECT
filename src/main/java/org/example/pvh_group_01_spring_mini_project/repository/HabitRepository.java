package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.*;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;

import java.util.List;

@Mapper
public interface HabitRepository {

    @Select("""
        SELECT * FROM habits
        OFFSET #{size} * (#{page} - 1)
        LIMIT #{size}
    """)
    @Results(id="habitMapper", value = {
            @Result(property = "habitId", column = "habit_id"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createAt", column = "created_at"),
            @Result(property = "appUserResponse", column = "app_user_id",
                    one = @One(select = "org.example.pvh_group_01_spring_mini_project.repository.ProfileRepository.getProfileById")
            )
    })

    List<Habit> getAllHabits(Integer page, Integer size);
}
