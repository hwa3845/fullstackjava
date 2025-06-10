package com.my.sts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.sts.model.DeptVo;

@SpringBootApplication
@RestController
public class Sts20Application implements ApplicationRunner{
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Sts20Application.class, args);
		
//		Module my=ac.getBean(Module.class);
//		my.func();

	}
	
	@GetMapping("/hello")
//	@ResponseBody
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01 page";
	}
	
	@GetMapping("/ex02")
	public List<?> ex02(){
		//jacson lib -> JSON 포맷으로 자동 변환 (브라우저에서 header 확인하면 json 형식인 것 확인 가능)
		List<String> list = List.of("item1", "item2", "item3");
		return list;
	}

	@GetMapping("/ex03")
	public Map<String, Object> ex03(){
		Map<String, Object> map= Map.of("key1",1111,"key2","val2","key3","val3");
		return map;
	}
	
	@GetMapping("/ex04")
	public Set<?> ex04(){
		Set<Object> list = Set.of("item1", 2222, Map.of("key1",1111,"key2","val2","key3","val3"));
		return list;
	}
	
	@GetMapping("/ex05")
	public DeptVo ex05() {
//		return new DeptVo(3333,"테스트3","test");
		//객체 시점 build() -> build 전에 수행할 것 넣어줌
		return DeptVo.builder()
				.deptno(1111)
				.dname("TEST")
				.loc("test")
				.build();
	}
	
	@GetMapping("/ex06")
	public String ex06(@RequestParam(defaultValue = "test") String name) {
		return name;
	}
	
	@GetMapping("/ex07")
	public DeptVo ex07(DeptVo bean) {
		return bean;
	}

	//form 형식으로 보내기 OR form-data로 만들어서 보내기
	@PostMapping("/ex08")
	public DeptVo ex08(@ModelAttribute DeptVo bean) {
		return bean;
	}

	//json 형식으로 보내기 (JS로 값 보내기)
	//responsebody vs requestbody
	@PostMapping("/ex09")
	public DeptVo ex09(@RequestBody DeptVo bean) {
		return bean;
	}

	//put -> form, json 모두 가능
	@PutMapping("/ex10")
	public DeptVo ex10(@ModelAttribute DeptVo bean) {
		return bean;
	}
	
	//build 패턴과 유사한 것 (특정 버전 이후 build 패턴 포함되어 있음)
	@GetMapping("/ex11")
	public ResponseEntity<?> ex11(){
//		return new ResponseEntity(HttpStatus.OK);
		//Ok는 build()까지 포함 나머지는 .build()해야 함
		return ResponseEntity.notFound().build();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		jdbcTemplate.update("insert into dept values (2222, 'test2', 'test')");
//		System.out.println(jdbcTemplate.queryForMap("select * from dept"));
//		jdbcTemplate.execute("create table emp(empno int, ename varchar(10))");
		
//		jdbcTemplate.execute("drop table dept");
//		jdbcTemplate.execute("create table dept(deptno int primary key, dname varchar(10), loc varchar(10))");
//		jdbcTemplate.update("insert into dept values (1111, '테스트1', '테스트')");
//		System.out.println(jdbcTemplate.queryForMap("select * from dept"));
		
		RowMapper rowMapper=(a,b)->{return a.getObject(1);};
		jdbcTemplate.query("select * from dept", rowMapper);
	}
	
}
