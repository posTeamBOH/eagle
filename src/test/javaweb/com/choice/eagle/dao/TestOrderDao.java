package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Order;

public class TestOrderDao extends BaseTest{

	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void testselectByTable() {
		List<Order> list = orderDao.selectByTable("T1001");
		assertEquals(1, list.size());
	}
	
	@Test
	public void testselectByRequire() {
		List<Order> list = orderDao.selectByRequire("O1001", "2001-02-02 11:12:44", "2016-02-02 11:12:44");
		List<Order> timelist = orderDao.selectByRequire(null, "2001-02-02 11:12:44", "2016-02-02 11:12:44");
		assertEquals(5, list.get(0).getOrderNum());
		assertEquals(5, timelist.get(0).getOrderNum());
	}
}
