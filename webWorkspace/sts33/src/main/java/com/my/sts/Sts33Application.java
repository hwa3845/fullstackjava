package com.my.sts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.EmpRepo;
import com.my.sts.model.entity.Dept;
import com.my.sts.model.entity.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Sts33Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts33Application.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(EmpRepo empRepo,DeptRepo deptRepo) {
		return ele->{
			Dept dept10=Dept.builder().deptno(10).dname("test1").loc("test").build();
			Dept dept20=Dept.builder().deptno(20).dname("test2").loc("test").build();
			deptRepo.save(dept10);
			deptRepo.save(dept20);
			Emp emp1=Emp.builder().dept(dept10).empno(1111).ename("tester1").build();
			Emp emp2=Emp.builder().dept(dept20).empno(2222).ename("tester2").build();
			Emp emp3=Emp.builder().dept(dept20).empno(3333).ename("tester3").build();
			empRepo.save(emp1);
			empRepo.save(emp2);
			empRepo.save(emp3);
			
			Emp resultEmp=empRepo.findJoin2(1111);
			System.out.println(resultEmp);
			
//			deptRepo.myAll2().forEach(System.out::println);
//			System.out.println(deptRepo.myOne2(10).getDname());
		};
	}
}
