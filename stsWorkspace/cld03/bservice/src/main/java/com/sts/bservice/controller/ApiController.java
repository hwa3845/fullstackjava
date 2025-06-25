package com.sts.bservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sts.bservice.model.DeptVo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiController {

    @GetMapping("/api/list")
    public List<?> list() throws Exception {
        try {
            Thread.sleep(7000);
            throw new RuntimeException("내가 만든 에러...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(
            DeptVo.builder()
                    .deptno(1111).dname("test1").loc("test").build(),
            DeptVo.builder()
                    .deptno(2222).dname("test2").loc("test").build(),
            DeptVo.builder()
                    .deptno(3333).dname("test3").loc("test").build()
                    );
    }
    
}