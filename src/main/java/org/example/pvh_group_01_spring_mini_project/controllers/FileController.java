package org.example.pvh_group_01_spring_mini_project.controllers;

import lombok.SneakyThrows;
import org.example.pvh_group_01_spring_mini_project.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload-file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file){
            return ResponseEntity.ok(fileService.uploadFile(file));
    }


    @SneakyThrows
    @GetMapping("/preview-file/{file-name}")
    public ResponseEntity<?> getFileByName(@PathVariable("file-name") String fileName){
        InputStream resource = fileService.getFileByName(fileName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource.readAllBytes());
    }
}
