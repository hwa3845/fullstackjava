package com.my.sts.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sts.model.DeptRepo;
import com.my.sts.model.DeptVo;
import com.my.sts.model.entity.Dept;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {
	private final DeptRepo deptRepo;

	@Cacheable("dept")
	@GetMapping("/")
	public List<?> list(){
		List<DeptVo> list=new ArrayList<>();
		deptRepo.findAll().forEach(ele->list.add(ele.voBuild()));
		return list;
	}
	
	
	//put으로 cache의 값을 넣어주기(문자열일 때, 여기서는 객체기 때문에 비권장)
//	@CachePut
	//cache 갱신 요청
	@CacheEvict(value = "dept",allEntries = true)
	@PostMapping("/")
	public DeptVo add(@RequestBody DeptVo bean) {
		return deptRepo.save(Dept.builder()
				.deptno(bean.getDeptno())
				.dname(bean.getDname())
				.loc(bean.getLoc())
				.build()).voBuild();
	}
}
