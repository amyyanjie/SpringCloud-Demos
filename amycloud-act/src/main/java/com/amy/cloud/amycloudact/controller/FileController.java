package com.amy.cloud.amycloudact.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/11 19:21
 */
@RestController
public class FileController {

    @PostMapping("file/upload")
    public String upload(@RequestParam MultipartFile file) {
        return file.getOriginalFilename();
    }
}
