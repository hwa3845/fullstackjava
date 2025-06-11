package com.my.sts.model.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends CrudRepository<Dept, Integer>{
	
	List<Dept> findByDname(String dname);
	
//	Dept findById(int id);
}
