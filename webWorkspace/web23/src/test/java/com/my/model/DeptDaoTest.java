package com.my.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	//3.x 어노테이션 없었기 때문에 네이밍 규칙(test로 시작) 존재했었음
	//4.x 어노테이션 존재(네이밍 자율), 관습적으로 test로 시작
	//테스트는 순서대로 하지 않음
	DeptDto target=new DeptDto(9999, "테스트", "강남");
	DeptDao dao;
	
	@Before
	public void setUp() {
		System.out.println("setup");
		dao=new DeptDao();
	}
	
	@After
	public void tearDown() {
		System.out.println("down");
	}
	
	@Test
	public void test1SelectAll() throws SQLException {
		System.out.println("selectAll");
		assertNotNull(dao.selectAll());
		assertNotSame(0, dao.selectAll().size());
//		assertTrue(dao.selectAll().size()>0);
	}

	@Test
	public void test3SelectOne() throws SQLException {
		DeptDto bean=dao.selectOne(target.getDeptno());
		assertNotNull(bean);
		assertEquals(target,bean);
	}
	
	@Test
	public void test2InsertOne() throws SQLException {
		//만약 primary key 있었으면 deptno 가 중복돼서 
		//junit 테스트 할 때마다 오류났을 것
		assertNotSame(0, dao.insertOne(target));
	}
	
	@Test
	public void test5DeleteOne() throws SQLException {
		assertNotSame(0, dao.deleteOne(target.getDeptno()));
	}
	
	@Test
	public void test4UpdateOne() throws SQLException {
		DeptDto target=new DeptDto(9999,"test","test1");
		assertNotSame(0, dao.updateOne(target));
	}
}
