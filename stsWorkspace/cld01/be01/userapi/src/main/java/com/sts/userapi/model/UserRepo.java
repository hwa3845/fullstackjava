package com.sts.userapi.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sts.userapi.model.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{

    Optional<User> findByNameAndPw(String name, String pw);
    //기본 제공 함수 사용 예정

    User findByName(String name);
}
