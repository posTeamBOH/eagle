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
	
}
