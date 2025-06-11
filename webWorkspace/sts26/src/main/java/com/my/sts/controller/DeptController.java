package com.my.sts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.sts.model.DeptVo;
import com.my.sts.service.DeptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class DeptController {
	private final DeptService deptService;
	
	@GetMapping("dept/")
	public List<DeptVo> getList(){
//		List<Dept> list = new ArrayList<>();
//		deptRepo.findAll()
//		.forEach(ele->{list.add(ele);});
//		return list;
		
		return deptService.selectAll();
	}
	
	@GetMapping("dept/{deptno}")
	public DeptVo pullList(@PathVariable int deptno) {
		return deptService.selectOne(deptno);
	}

	@PostMapping("dept/")
	public ResponseEntity<?> addList(@ModelAttribute DeptVo deptVo){		
		try {
			deptVo = deptService.insertOne(deptVo);
			return ResponseEntity.status(HttpStatus.CREATED).body(deptVo);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("dept/{deptno}")
	public ResponseEntity<?> editList(@PathVariable int deptno, @RequestBody DeptVo bean) {
		try{
			DeptVo result=deptService.updateOne(bean);
			return ResponseEntity.ok(List.of(result));
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("dept/{deptno}")
	public ResponseEntity<?> rmlist(@PathVariable int deptno){
		try {
			deptService.deleteOne(deptno);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
		
	}
}
