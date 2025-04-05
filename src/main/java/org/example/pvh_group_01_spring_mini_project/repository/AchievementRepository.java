package org.example.pvh_group_01_spring_mini_project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.pvh_group_01_spring_mini_project.models.entity.Achievement;
import org.example.pvh_group_01_spring_mini_project.util.UUIDTypeHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AchievementRepository {
    @Select("""
        SELECT * FROM achievement LIMIT #{size} OFFSET (#{page}-1) * #{size};
    """)
    @Results(id = "AchievementMapper", value = {
            @Result(property = "achievementId", column = "achievement_id", typeHandler = UUIDTypeHandler.class),
            @Result(property = "xpRequired", column = "xp_required")
    })
    List<Achievement> getAllAch(Integer page, Integer size);

    @Select("""
        SELECT * FROM achievemen LIMIT #{size} OFFSET (#{page}-1) * #{size};
    """)
    @RequestMapping("AchievementMapper")
    Achievement getAchByid(Integer appid, Integer page, Integer size);
}
