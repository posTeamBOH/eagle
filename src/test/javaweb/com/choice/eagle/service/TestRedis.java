package com.choice.eagle.service;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.controller.RorderController;
import com.choice.eagle.entity.Order;
import com.choice.eagle.entity.Rorder;

public class TestRedis extends BaseTest{

	Logger logger = LoggerFactory.getLogger(RorderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testRedis() {
		List<Order> list = orderService.selectByRequire(null, null, null);
		logger.info(list.get(0).getOrderId());
		
		List<Order> list2 = orderService.selectByRequire("O1001", null, null);
		logger.info(list2.get(0).getOrderId());
		
		List<Order> list3 = orderService.selectByRequire(null, null, null);
		logger.info(list3.get(0).getOrderId());
	}
}
