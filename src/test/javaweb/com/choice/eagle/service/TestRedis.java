package com.choice.eagle.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.cache.JedisUtil;
import com.choice.eagle.controller.RorderController;
import com.choice.eagle.entity.Order;
import com.choice.eagle.entity.Rorder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestRedis extends BaseTest{

	Logger logger = LoggerFactory.getLogger(RorderController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	
	private static String CESHIKEY = "ceshilist";
	
	@Test
	public void testRedis() {
		String key = CESHIKEY;
		List<Order> ceshilist = orderService.selectByRequire(null, null, null);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(ceshilist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jedisStrings.set(key, jsonString);
		assertEquals(jsonString, jedisStrings.get(key));
	}
}
