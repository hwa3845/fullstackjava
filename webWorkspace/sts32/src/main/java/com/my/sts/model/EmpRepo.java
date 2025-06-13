package com.my.sts.model;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.my.sts.model.entity.Emp;

@Mapper
public interface EmpRepo { //extends CrudRepository<Emp, Integer>{

//	Optional<Emp> findByName(String name);
	
	@Select("select * from emp where id=#{val}")
	Emp findByName(String name);
}
