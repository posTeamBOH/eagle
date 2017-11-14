package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Menu;

public class TestRorderDao extends BaseTest {

	@Autowired
	private RorderDao rorderDao;
	
	@Test
	public void testupdateMenuStatus() {
		assertEquals(1, rorderDao.updateMenuStatus("r1001"));
	}
	
	@Test
	public void testselectMenuByOrderId() {
		Map<String, Integer> map = rorderDao.selectMenuByOrderId("O1001");
		assertEquals(Integer.valueOf(1), map.get("count"));
	}
}
