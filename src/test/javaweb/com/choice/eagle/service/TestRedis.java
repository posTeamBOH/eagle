package com.choice.eagle.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.cache.JedisUtil;
import com.choice.eagle.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestRedis extends BaseTest{

	Logger logger = LoggerFactory.getLogger(TestRedis.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	
	private static String CESHIKEY = "ceshilist";
	
	@Test
	public void testRedis() {
		logger.info("====start====");
		String key = CESHIKEY;
		List<Order> ceshilist = orderService.selectByRequire(null, null, null);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(ceshilist);
		} catch (JsonProcessingException e) {
			logger.debug(e.toString());
			logger.error(e.toString());
			e.printStackTrace();
		}
		logger.debug("TestRedis类 testRedis方法");
		jedisStrings.set(key, jsonString);
		logger.info("====end====");
		assertEquals(jsonString, jedisStrings.get(key));
	}
}
