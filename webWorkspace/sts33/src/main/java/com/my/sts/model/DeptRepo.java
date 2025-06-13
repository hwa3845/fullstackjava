package com.my.sts.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.my.sts.model.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept, Integer>{

	//jpql
	@Query("select i from Dept i")
	List<Dept> myAll1();
	@Query("select i from Dept i where i.deptno=:deptno")
	Dept myOne1(@Param(value="deptno") int deptno);
	@Query(value="select * from Dept", nativeQuery = true)
	List<Dept> myAll2();
	@Query(value="select * from Dept where deptno=:deptno", nativeQuery = true)
	Dept myOne2(@Param(value="deptno") int deptno);

}
