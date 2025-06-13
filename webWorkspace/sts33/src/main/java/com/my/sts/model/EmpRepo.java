package com.my.sts.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.my.sts.model.entity.Emp;

public interface EmpRepo extends CrudRepository<Emp, Integer>{
	
	@Query("SELECT m FROM Emp m INNER JOIN m.dept t where m.empno=:empno")
	Emp findJoin1(int empno);
	
	@Query(value="SELECT * FROM emp m INNER JOIN dept d using (deptno) where m.empno=:empno",nativeQuery = true)
	Emp findJoin2(int empno);
}
