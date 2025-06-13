package com.my.sts.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.my.sts.model.entity.Auths;

@Mapper
public interface AuthsRepo { //extends CrudRepository<Auths, Integer>{

	@Select("select * from auths where id=#{val}")
	List<Auths> findByName(String name);
}
