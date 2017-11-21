package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;

public class TestRorderDao extends BaseTest {

	@Autowired
	private RorderDao rorderDao;
	
	@Test
	public void testupdateMenuStatus() {
		assertEquals(2, rorderDao.updateMenuStatus("O1001", "测试菜品"));
	}
	
	@Test
	public void testcountAllMenuByOrderId() {
		assertEquals(1, rorderDao.countAllMenuByOrderId("O1001"));
	}
	
	@Test
	public void testupdateOrderStatus() {
		assertEquals(1, rorderDao.updateOrderStatus("O1001"));
	}
	
	@Test
	public void testupdateTableStatus() {
		assertEquals(1, rorderDao.updateTableStatus("T1001", "没人"));
	}
	
	@Test
	public void testcountNotUpdate() {
		assertEquals(3, rorderDao.countNotUpdate("O1001"));
	}
	
	@Test
	public void testinsertOrder() {
		
	}
}
