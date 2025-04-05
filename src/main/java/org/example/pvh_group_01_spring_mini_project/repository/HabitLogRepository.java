package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.*;
import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitLogRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.HabitLog;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitLogRepository {

    @Select("""
            SELECT * FROM habit_logs
            """)
    @Results(id = "habitLogMapper", value = {
            @Result(property = "habitLogId", column = "habit_log_id"),
            @Result(property = "logDate", column = "log_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "xpEarned", column = "xp_earned"),
            @Result(property = "habit", column = "habit_id",
                    one = @One(select = "org.example.pvh_group_01_spring_mini_project.repository.HabitRepository.getHabitById")),
            @Result(property = "createdAt", column = "created_at")
    })
    List<HabitLog> getAllHabitLog();


    @Select("""
    INSERT INTO habit_logs (status, habit_id, log_date, created_at)
    VALUES (#{request.status}, #{request.habitId}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
    RETURNING habit_log_id, log_date, status, xp_earned, habit_id, created_at
    """)
    @ResultMap("habitLogMapper")
    @Options(useGeneratedKeys = true, keyProperty = "habitLogId")
    HabitLog addHabitLog(@Param("request") HabitLogRequest habitLogRequest);


    @Select("""
   SELECT COUNT(*)
   FROM habit_logs
   WHERE habit_id = #{habitId}
   AND status = 'COMPLETED';
   
    """)
    int countCompletedLogs(UUID habitId);



}