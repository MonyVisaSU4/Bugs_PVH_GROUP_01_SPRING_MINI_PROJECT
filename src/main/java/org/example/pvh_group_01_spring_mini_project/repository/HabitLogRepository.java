package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.*;
import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitLogRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.HabitLog;

import java.util.List;

@Mapper
public interface HabitLogRepository {
    @Select(" INSERT INTO  habit_logs (status, habit_id) VALUES (#{status}, #{habitId})")
    @Results(id = "habitLogMapper", value = {
            @Result(property = "habitLogId", column = "habit_log_id"),
            @Result(property = "logDate", column = "log_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "xpEarned", column = "xp_earned"),
            @Result(property = "habitId", column = "habit_id"),

    })
    HabitLog addHabitLog(HabitLogRequest habitLogRequest);


    @Select(" SELECT * FROM habit_logs")
    @ResultMap("habitLogMapper")
    List<HabitLog> getAllHabitLog();
}