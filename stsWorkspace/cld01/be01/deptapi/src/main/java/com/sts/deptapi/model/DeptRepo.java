package com.sts.deptapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.deptapi.model.entity.Dept;

public interface DeptRepo extends JpaRepository<Dept, Integer>{
    //별도 정의 없이 제공해주는 함수 쓸 예정
}
