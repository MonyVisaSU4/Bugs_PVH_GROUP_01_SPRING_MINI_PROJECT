package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.pvh_group_01_spring_mini_project.models.entity.Achievement;

import java.util.List;

@Mapper
public interface AchievementRepository {
    @Select("""
        SELECT * FROM achievement;
    """)
    @Results(id = "AchievementMapper", value = {
            @Result(property = "achievementId", column = "achievement_id"),
            @Result(property = "xpRequired", column = "xp_required")
    })
    List<Achievement> getAllAch();
}
