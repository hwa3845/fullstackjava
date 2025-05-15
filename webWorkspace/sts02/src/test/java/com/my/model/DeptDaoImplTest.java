package com.my.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoImplTest {
	static ApplicationContext ac;
	DeptDao dao;
	DeptDto target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		//getBean 은 이름 매칭이 아니라 타입 매칭
		dao=ac.getBean(DeptDaoImpl.class);
		target=new DeptDto(1010,"test","test1");
	}

	@Test
	public void test1SelectAll() {
		assertNotNull(dao.selectAll());
	}

	@Test
	public void test2InsertOne() {
		dao.insertOne(target);
	}
	
	@Test
	public void test3SelectOne() {
		assertEquals(target, dao.selectOne(target.getDeptno()));
	}
	
	@Test
	public void test4UpdateOne() {
		target.setDname("test2");
		assertEquals(1, dao.updateOne(target));
	}
	
	@Test
	public void test5DeleteOne() {
		assertSame(1, dao.deleteOne(target.getDeptno()));
	}
}
