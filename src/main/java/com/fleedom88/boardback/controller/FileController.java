package com.fleedom88.boardback.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fleedom88.boardback.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
// Lombok에서 @Getter, @Setter 어노테이션 처럼 @RequiredArgsConstructor어노테이션은 클래스에 
//선언된 final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성해주는 어노테이션
@RequiredArgsConstructor
public class FileController {
    
    private final FileService fileService;

    @PostMapping("/upload")
    public String upload(
        @RequestParam("file") MultipartFile file
    ) {
       String url = fileService.upload(file);
       return url;
    }
    
    @GetMapping(value = "{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public Resource getImage(
        @PathVariable("fileName") String fileName
    ){
        Resource resource = fileService.getImage(fileName);
        return resource;
    }

}
