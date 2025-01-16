package com.wzb.controller;

import com.wzb.service.DeptService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

}
