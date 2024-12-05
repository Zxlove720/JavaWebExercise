package com.wzb.controller;

import com.wzb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@RestController
public class FileController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) {
        //image.transferTo(new File("E:\\imagesTest\\"));
        return Result.success();
    }
}
