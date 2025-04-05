package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pvh_group_01_spring_mini_project.models.dto.request.HabitLogRequest;
import org.example.pvh_group_01_spring_mini_project.models.entity.HabitLog;

import java.util.List;

@Mapper
public interface HabitLogRepository {
    @Select(" INSERT INTO  habit_logs (status, habit_id) VALUES (#{status}, #{habitId})")
    HabitLog addHabitLog(HabitLogRequest habitLogRequest);


    @Select(" SELECT * FROM habit_logs")
    List<HabitLog> getAllHabitLog();
}