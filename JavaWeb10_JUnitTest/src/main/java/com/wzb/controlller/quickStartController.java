package com.wzb.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class quickStartController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World" + LocalDateTime.now();
    }

}
