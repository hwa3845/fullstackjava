package com.sts.emp02_3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/")
    public List<?> list() {
        return List.of("a아이템1","a아이템2","a아이템3","a아이템4");
    }
}
