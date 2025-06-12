package com.my.sts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.EmpRepo;
import com.my.sts.model.entity.Dept;
import com.my.sts.model.entity.Emp;

@SpringBootApplication
public class Sts27Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts27Application.class, args);
	}
	
//	@Transactional
	@Bean
	public CommandLineRunner runner(DeptRepo deptRepo,EmpRepo empRepo) {
		return args->{
//			Dept dept1=Dept.builder()
//					.deptno(10)
//					.dname("test1")
//					.loc("test")
//					.build();
//			deptRepo.save(dept1);
//			Dept dept2=Dept.builder()
//					.deptno(20)
//					.dname("test2")
//					.loc("test")
//					.build();
//			deptRepo.save(dept2);
			
//			Emp emp=Emp.builder()
//					.empno(1111)
//					.deptno(10)
//					.ename("user01")
//					.nalja(LocalDate.now())
//					.build();
			//join 한 후
//			empRepo.save(Emp.builder().sal(1000).empno(1111).ename("user01").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(2000).empno(2222).ename("user02").dept(dept2).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(3000).empno(3333).ename("user03").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(2500).empno(4444).ename("한글04").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(1500).empno(5555).ename("한글05").dept(dept2).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(1200).empno(6666).ename("한글06").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(3000).empno(7777).ename("user77").dept(dept1).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(4500).empno(8888).ename("user88").dept(dept2).nalja(LocalDate.now()).build());
//			empRepo.save(Emp.builder().sal(2500).empno(9999).ename("user99").dept(dept1).nalja(LocalDate.now()).build());
			
//			Emp emp2=empRepo.findById(1111).get();
//			Dept dept2=deptRepo.findById(emp2.getDeptno()).get();
//			System.out.println(dept2);
			//join 한 후 
			Emp emp1111=empRepo.findById(1111).get();
//			System.out.println(emp1111.getEname());
			System.out.println(emp1111.getDept());
			
			Dept dept10=deptRepo.findById(10).get();
//			dept10.getEmps().add(Emp.builder().empno(6666).build());
			System.out.println(dept10);
			
//			System.out.println(empRepo.findByEname("user01")); 
//			System.out.println(empRepo.findByEnameAndSal("user02",2000));
//			empRepo.findByEnameOrSal("user02", 1000).forEach(System.out::println);
//			empRepo.findBySalBetween(1000, 2000).forEach(System.out::println);
//			empRepo.findBySalLessThan(2000).forEach(System.out::println);
//			empRepo.findBySalLessThanEqual(2000).forEach(System.out::println);
//			empRepo.findBySalIn(1000,2000).forEach(System.out::println);
//			empRepo.findBySalBetweenOrderBySalDesc(1000,2000).forEach(System.out::println);
//			empRepo.findByEnameLike("%0%").forEach(System.out::println);
			
//			Sort sort=Sort.by("sal").descending();
//			empRepo.findAll(sort).forEach(System.out::println);
//			Pageable pageable=PageRequest.of(0, 3).withSort(sort);
//			empRepo.findAll(pageable).forEach(System.out::println);
		};
		
	}
}
