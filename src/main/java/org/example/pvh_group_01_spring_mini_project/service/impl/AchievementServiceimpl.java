package org.example.pvh_group_01_spring_mini_project.service.impl;

import org.example.pvh_group_01_spring_mini_project.models.entity.Achievement;
import org.example.pvh_group_01_spring_mini_project.repository.AchievementRepository;
import org.example.pvh_group_01_spring_mini_project.service.AchievementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceimpl implements AchievementService {
    private final AchievementRepository achievementRepository;

    public AchievementServiceimpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Override
    public List<Achievement> getAllAch(Integer page, Integer size) {
        return achievementRepository.getAllAch(page, size);
    }

    @Override
    public Achievement getAchByid(Integer appid, Integer page, Integer size) {
        return achievementRepository.getAchByid(appid, page, size);
    }
}
