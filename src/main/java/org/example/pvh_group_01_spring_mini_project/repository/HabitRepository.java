package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.*;
import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.Habit;
import org.example.pvh_group_01_spring_mini_project.util.UUIDTypeHandler;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {
    @Select("""
            SELECT * FROM habits
            """)
    @Results(id = "habitMapper",value = {
            @Result(property = "habitId",column = "habit_id", typeHandler = UUIDTypeHandler.class),
            @Result(property = "isActive",column = "is_active"),
            @Result(property = "createAt",column = "created_at"),

    })
    List<Habit> getAllHabits();

    @Select(
            """
            INSERT INTO habits (habit_id,title, description, frequency,is_active,created_at) VALUES (gen_random_uuid(),#{req.title},#{req.description},#{req.frequency},true,localtimestamp) RETURNING *
            """)
    @ResultMap("habitMapper")
    Habit addHabit(@Param("req") HabitRequest habitRequest);
}
