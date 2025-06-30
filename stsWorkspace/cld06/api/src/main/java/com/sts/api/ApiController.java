package com.sts.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/")
    public String info() {
        return "info page";
        //login했을 때 접속 가능
    }
    
}
