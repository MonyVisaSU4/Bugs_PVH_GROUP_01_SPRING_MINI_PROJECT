package org.example.pvh_group_01_spring_mini_project.service;

import org.example.pvh_group_01_spring_mini_project.models.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {
    File uploadFile(MultipartFile multipartFile);
    InputStream getFileByName(String fileName);
}
