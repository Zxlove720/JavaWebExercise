package com.wzb.controller;

import com.wzb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class FileController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        // 获取原文件名
        String originalFilename = image.getOriginalFilename();
        // 获取最后一个“.”的索引
        int index = originalFilename.lastIndexOf(".");
        // 通过subString方法和最后一个“.”索引进行截取，获取文件扩展名
        String externalName = originalFilename.substring(index);
        // UUID + 扩展名 = 新文件名
        String newFileName = UUID.randomUUID().toString() + externalName;
        image.transferTo(new File("E:\\imagesTest\\" + newFileName));
        return Result.success();
    }
}
