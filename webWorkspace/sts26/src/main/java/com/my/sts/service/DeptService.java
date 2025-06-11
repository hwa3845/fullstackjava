package com.my.sts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.DeptVo;
import com.my.sts.model.entity.Dept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //생성자 주입 , 주입받는 필드가 final 이어야 함 
//-> 없으면 오류, 순서가 명세됨(service가 있어야)
//autowired로 주입받지 못할 경우가 있기 때문에 (setter와의 순서 문제 등)
public class DeptService {
	private final DeptRepo deptRepo;
	
	public List<DeptVo> selectAll(){
		List<DeptVo> list = new ArrayList<>();
		deptRepo.findAll().forEach(dept->list.add(dept.voBuild()));
		return list;
	}

	public DeptVo selectOne(int deptno) {
		Dept dept=deptRepo.findById(deptno).get();
		return dept.voBuild();
	}
	
	public DeptVo insertOne(DeptVo bean) {
		Dept dept=deptRepo.save(Dept.builder()
				.dname(bean.getDname())
				.loc(bean.getLoc())
				.build());
		bean.setDeptno(dept.getDeptno());
		return bean;
	}

	public DeptVo updateOne(DeptVo bean) {
//		Dept dept=deptRepo.findById(bean.getDeptno()).get();
		Dept dept=Dept.builder()
				.deptno(bean.getDeptno())
				.dname(bean.getDname())
				.loc(bean.getLoc())
				.build();
		deptRepo.save(dept);
		return bean;
	}
	
	public void deleteOne(int deptno) {
		Dept dept=deptRepo.findById(deptno).get();
		deptRepo.delete(dept);
		
		//deptRepo.deleteById(deptno);
	}
}
